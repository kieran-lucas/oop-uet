public class Main {


    static class AppConfig {
        private static volatile AppConfig instance;

        private String appName;
        private String version;
        private String logLevel;

        private AppConfig() {
            this.appName = "MyApp";
            this.version = "1.0";
            this.logLevel = "INFO";
        }

        public static AppConfig getInstance() {
            if (instance == null) {
                synchronized (AppConfig.class) {
                    if (instance == null) {
                        instance = new AppConfig();
                    }
                }
            }
            return instance;
        }
    }


    public static void main(String[] args) {

        Runnable task = new Runnable() {
        @Override
        public void run() {
            AppConfig config = AppConfig.getInstance();
            System.out.println(Thread.currentThread().getName() 
            + ": " + config.hashCode());
        }
    };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}