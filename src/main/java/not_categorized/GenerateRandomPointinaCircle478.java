package not_categorized;

import java.util.Random;

public class GenerateRandomPointinaCircle478 {

    private final double radius;
    private final double xCenter;
    private final double yCenter;
    private final double randomMax;
    private final Random random = new Random();

    public GenerateRandomPointinaCircle478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.randomMax = radius * 2;
    }

    public double[] randPoint() {
        while (true) {
            final double x = xCenter - radius + randomMax * random.nextDouble();
            final double y = yCenter - radius + randomMax * random.nextDouble();
            if ((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius) {
                return new double[]{x, y};
            }
        }
    }
}
