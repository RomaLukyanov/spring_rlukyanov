package prime.com.example.spring_rlukyanov.reflection;

public class DemonstrateReflectionClass {
        private int number;
        private String name = "default";
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String getPrivateString() {
            return "SecretString";
        }
        private String getPrivateString(String secretString) {
            String test = "";
            
            return secretString;
        }
}
