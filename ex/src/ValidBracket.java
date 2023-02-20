public class ValidBracket {
    Character bracket;
    Boolean isValid;

    public ValidBracket(Character bracket, Boolean isValid) {
        this.bracket = bracket;
        this.isValid = isValid;
    }

    public Character getBracket() {
        return bracket;
    }

    public void setBracket(Character bracket) {
        this.bracket = bracket;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}