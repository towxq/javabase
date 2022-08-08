package spring.iocdemo;

public class UserController {
    @Autowired
    private UserService userService;

    @AutoValue("wxq123")
    private String ss;

    public void print() {
        System.out.println(userService.name + "----" + ss);
    }
}
