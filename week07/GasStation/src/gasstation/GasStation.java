/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation;

/**
 *
 * @author souravpalit
 */
public class GasStation {
    
    public static void main(String args[]) {
        int [] gas = {2, 3, 4};
        int [] cost = {3, 4, 3};
        System.out.println(canCompleteCircuitOptimal(gas, cost));
        
    }

    // TC: O(n^2) SC: O(1)
    // Time Limit Exceeded
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int numberOfStations = gas.length;

        for (int startingCityIdx = 0; startingCityIdx < numberOfStations; startingCityIdx++) {
            int maxCityIdx = startingCityIdx + numberOfStations;
            int remainingGas = 0;
            for (int cityIdx = startingCityIdx; cityIdx < maxCityIdx; cityIdx++) {
                if (remainingGas < 0) {
                    break;
                }

                int currentCityIdx = cityIdx % numberOfStations;
                remainingGas += gas[currentCityIdx];
                int distanceToNextCity = cost[currentCityIdx];
                remainingGas -= distanceToNextCity;
            }

            if (remainingGas >= 0) {
                return startingCityIdx;
            }
        }

        return -1;
    }

    // TC: O(n) SC: O(1)
    public static int canCompleteCircuitOptimal(int[] gas, int[] cost) {
        int numberOfStations = gas.length;
        int startingCityIdx = 0;
        int currentFuelAmount = 0;
        int minFuelAtStartingCityIdx = 0;

        for (int cityIdx = 1; cityIdx < numberOfStations; cityIdx++) {
            int fuelFromPreviousCity = gas[cityIdx - 1];
            int distanceFromPreviousCity = cost[cityIdx - 1];
            currentFuelAmount += fuelFromPreviousCity;
            currentFuelAmount -= distanceFromPreviousCity;

            if (currentFuelAmount < minFuelAtStartingCityIdx) {
                minFuelAtStartingCityIdx = currentFuelAmount;
                startingCityIdx = cityIdx;
            }
        }

        return isValidStartingCity(gas, cost, startingCityIdx) ? startingCityIdx : -1;
    }

    public static boolean isValidStartingCity(int[] gas, int[] cost, int startingCityIdx) {
        int maxCityIdx = startingCityIdx + gas.length;
        int remainingGas = 0;
        for (int cityIdx = startingCityIdx; cityIdx <= maxCityIdx; cityIdx++) {
            if (remainingGas < 0) {
                return false;
            }

            int currentCityIdx = cityIdx % gas.length;
            remainingGas += gas[currentCityIdx];
            int distanceToNextCity = cost[currentCityIdx];
            remainingGas -= distanceToNextCity;
        }

        return true;
    }
    
    
    // TC:: O(n) SC: O(1)
    public int canCompleteCircuitBest(int[] gas, int[] cost) { 
        int totalGas= 0;
        int currentGas = 0;
        int startingStationIdx = 0;
        
        for (int stationIdx = 0; stationIdx < gas.length; stationIdx++) {
            totalGas += gas[stationIdx] - cost[stationIdx];
            currentGas += gas[stationIdx] - cost[stationIdx];
            
            if (currentGas < 0) {
                currentGas = 0;
                startingStationIdx = stationIdx + 1;
            }
        }
        
        return (totalGas < 0) ? -1 : startingStationIdx;
        
    }

}
