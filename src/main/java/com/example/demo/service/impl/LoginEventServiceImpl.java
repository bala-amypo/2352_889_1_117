



public class LoginEventServiceImpl implements LoginEventService {
    private final LoginEventRepository repo;
    private final Object evaluator;

    public LoginEventServiceImpl(LoginEventRepository repo, Object evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }
    public LoginEvent recordLogin(LoginEvent e) { return repo.save(e); }
    public List<LoginEvent> getEventsByUser(Long id) { return repo.findByUserId(id); }
    public List<LoginEvent> getSuspiciousLogins(Long id) {
        return repo.findByUserIdAndLoginStatus(id, "FAILED");
    }
}
