
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Neuron {
    private final List<Double> weights;
    private final double bias;
    private final Function<Double, Double> activationFunction;

    public Neuron(List<Double> weights, double bias, Function<Double,Double> activationFunction) {
        this.weights = weights;
        this.bias = bias;
        this.activationFunction = activationFunction;
    }

    public Neuron(int previousLayerSize, Function<Double,Double> activationFunction) {
        List<Double> w = new ArrayList<> ();

        for (int i=0; i<previousLayerSize; i++) {
            w.add(Math.random());
        }

        this.weights = w;
        this.activationFunction = activationFunction;
        this.bias = Math.random();
    }

    public double forward(List<Double> previousActivations) {
        double weightedSum = 0;
        for (int i=0; i<weights.size(); i++) {
            weightedSum += weights.get(i) * previousActivations.get(i);
        }
        return activationFunction.apply(weightedSum) + bias;
    }
};