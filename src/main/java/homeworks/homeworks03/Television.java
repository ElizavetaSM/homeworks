package homeworks.homeworks03;

public class Television { // задаем характеристики телевизора
    private Integer diagonal;
    private Integer rom;
    private Integer ram;
    private Integer power;
    private String colour;

    public Television (Integer diagonal, Integer power, String colour) { //конструктор 1
        this.diagonal = diagonal;
        this.power = power;
        this.colour = colour;
        this.rom = 16;
        this.ram=2;
    }
    public Television () { // конструктор 2 со стандартными параметрами телевизора
        this.diagonal = 70;
        this.power = 77;
        this.rom =16;
        this.ram = 2;
        this.colour = "Black";
    }

    @Override // переопределение метода toString
    public String toString() {
        return "Television{" +
                "diagonal=" + diagonal +
                ", rom=" + rom +
                ", ram=" + ram +
                ", power=" + power +
                ", colour='" + colour + '\'' +'}';
    }

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
