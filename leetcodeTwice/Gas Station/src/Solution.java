/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int total = 0;
		int leftGas = 0;
		int index = 0;
		for (int i = 0; i < len; ++i) {
			leftGas += (gas[i] - cost[i]);
			if (leftGas < 0) {
				total += leftGas;
				leftGas = 0;
				index = i + 1;// restart from this station
			}
			total += leftGas;
		}
		return total < 0 ? -1 : index;
	}
}
