/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumnumberofacceptedinvitations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class MaximumNumberOfAcceptedInvitations {

    int numOfBoys, numOfGirls;
    
    // TC: O(N^3) SC: O(N)
    public int maximumInvitations(int[][] grid) {
        int invitations = 0;
        numOfBoys = grid.length;
        numOfGirls = grid[0].length;
        
        int [] girlsPairWithBoys = new int [numOfGirls];
        Arrays.fill(girlsPairWithBoys, -1);
        
        for (int boyIdx = 0; boyIdx < numOfBoys; boyIdx++) {
            Set<Integer> invitedAlready = new HashSet<>();
            if (canInvite(grid, boyIdx, invitedAlready, girlsPairWithBoys)) {
                invitations++;
            }
        }
        
        return invitations;
    }

    public boolean canInvite(
            int [][] grid, 
            int boyIdx,
            Set<Integer> invitedAlready, 
            int [] girlsPairWithBoys
    ) {
       for (int girlIdx = 0; girlIdx < numOfGirls; girlIdx++) {
           // If can invite this girl
           if (grid[boyIdx][girlIdx] == 1 && !invitedAlready.contains(girlIdx)) {
               // We can invite this girl. So send invitation
               invitedAlready.add(girlIdx);
               // If this girl is not paired with any boy or if paired if the 
               // girl can managee to tell the boy pair with another girl then
               // we can pair this boy with this girl
               if (girlsPairWithBoys[girlIdx] == -1 || 
                       canInvite(grid, girlsPairWithBoys[girlIdx], invitedAlready, girlsPairWithBoys)) {
                   girlsPairWithBoys[girlIdx] = boyIdx;
                   return true;
               }
           }
       } 
       return false;
    }
    
}
