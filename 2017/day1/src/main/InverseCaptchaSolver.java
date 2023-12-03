package main;

public class InverseCaptchaSolver {
    public int captchaSolverPart1(String captcha) {
        int result = 0;
        for (int i = 0; i < captcha.length() - 1; i++) {
            if (captcha.charAt(i) == captcha.charAt(i + 1)) {
                result += captcha.charAt(i) - 48;
            }
        }

        if (captcha.charAt(captcha.length() - 1) == captcha.charAt(0)) {
            result += captcha.charAt(0) - 48;
        }
        return result;
    }

    public int captchaSolverPart2(String captcha) {
        int result = 0;
        int length = captcha.length();


        int offset = length / 2;

        for (int i = 0; i < length; i++) {
            if (captcha.charAt(i) == captcha.charAt((i + offset) % length)) {
                result += captcha.charAt(i) - 48;
            }
        }

        return result;
    }
}
