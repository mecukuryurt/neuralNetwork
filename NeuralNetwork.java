import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class NeuralNetwork {
    private final List<List<Neuron>> layers = new ArrayList<>();
    
    public NeuralNetwork(List<Integer> layerSizes, Function<Double,Double> activationFunction) {
        for (int i = 1; i < layerSizes.size(); i++) {
            List<Neuron> currentLayer = new ArrayList<>();
            
            for (int j=0; j<layerSizes.get(i); j++) {
                currentLayer.add(new Neuron(layerSizes.get(i-1), activationFunction));
            }
            layers.add(currentLayer);
        }
    }

    public List<Double> calculate(List<Double> inputLayer) {
        List<Double> previousResult = inputLayer;
        for (List<Neuron> layer : layers) {
            List<Double> currentResult = new ArrayList<>();
            for (Neuron neuron : layer) {
                double result = neuron.forward(previousResult);
                currentResult.add(result);
            }
            previousResult = currentResult;
        }
        return previousResult;
    }
    
}
