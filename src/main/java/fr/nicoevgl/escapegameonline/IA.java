package fr.nicoevgl.escapegameonline;

import java.util.Random;

public class IA extends Game implements IAttacker, IDefender {
    @Override
    public int[] generateCombi() {
        Random rdCombi = new Random();
        for (int i = 0; i < combinationSize; i++) {
            combination[i] = rdCombi.nextInt(max[i] + 1);
        }
        return combination;
    }


    @Override
    public int[] generateProp() {
        for (int i = 0; i < combinationSize; i++) {
            Random rdProp = new Random();
            proposition[i] = rdProp.nextInt(max[i] + 1);
        }
        return proposition;
    }

    @Override
    public int[] generateNewProp(int[] secretCombination, int[] firstProposition) {
        Random rdProp2 = new Random();

        for (int i = 0; i < secretCombination.length; i++) {

            if (secretCombination[i] < firstProposition[i]) {
                max[i] = firstProposition[i];
                proposition[i] = rdProp2.nextInt(this.max[i]);
                response[i] = "-";
            } else if (secretCombination[i] > firstProposition[i]) {
                min[i] = firstProposition[i];
                proposition[i] = rdProp2.nextInt((max[i] - min[i]) + 1) + (min[i] + 1);
                response[i] = "+";
            } else {
                response[i] = "=";
            }
        }
        return proposition;
    }
}
