@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;

    public AuthResponse login(AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).get();

        String accessToken = jwtUtil.generateAccessToken(user);
        RefreshToken refreshToken =
                refreshTokenService.createRefreshToken(user.getUsername());

        return new AuthResponse(
                accessToken,
                refreshToken.getToken(),
                user.getRole().name()
        );
    }

    public AuthResponse refresh(String refreshTokenStr) {

        RefreshToken refreshToken =
                refreshTokenService.verify(refreshTokenStr);

        User user = refreshToken.getUser();

        // ROTATION — delete old
        refreshTokenService.deleteByUser(user);

        String newAccess = jwtUtil.generateAccessToken(user);
        RefreshToken newRefresh =
                refreshTokenService.createRefreshToken(user.getUsername());

        return new AuthResponse(
                newAccess,
                newRefresh.getToken(),
                user.getRole().name()
        );
    }
}