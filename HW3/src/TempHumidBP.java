public class TempHumidBP extends TempHumidTemplate{

    @Override
    public double maxTemperature() {
        super.clean();
        super.parse();
        super.sort();
        return super.maxTemperature();
    }

    /**
     * @return minimum temperature of stored data.
     */
    @Override
    public double minHumidity() {
        super.clean();
        super.parse();
        super.sort();
        return super.minHumidity();
    }
}
