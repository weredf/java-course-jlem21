class Car {
    km = 0;

    constructor(number, speed, color) {
        this.number = number;
        this.speed = speed;
        this.color = color;
    }

    drive(distance) {
        this.km += distance;
    }

    toString() {
        return "Car[numbers="+this.number+", speed="+this.speed+", color="+this.color+", km="+this.km+"]";
    }
}