/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sajid
 */
public class SearchSolution {

    public static void main(String[] args) {

        SearchSolution bfs = new SearchSolution();
        bfs.bfs();

    }

    public void bfs() {

        boolean solutionFound = false;

        Set<State> closedSet = new HashSet<>();
        Queue<Node> fringe = new LinkedList<>();

        State.initializeProblem(3, 3);

        fringe.add(new Node(new State(State.totalNumOfMissionaries, 0, State.totalNumOfCannibals, 0, 0), 0, null));

        Node currentNode = null;
        State currentState;
        int numberOfNodesExpanded = 0;

        while (!fringe.isEmpty()) {
            currentNode = fringe.poll();
            currentState = currentNode.state;
//
//            numberOfNodesExpanded++;
//            System.out.println(currentState);

            if (currentState.goalTest()) {
                solutionFound = true;
                break;
            }

            closedSet.add(currentState);

                      if (currentState.oneM() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.oneM(), currentNode.cost + 1, currentNode));
            }
            if (currentState.OneC() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.OneC(), currentNode.cost + 1, currentNode));
            }
            if (currentState.TwoM() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.TwoM(), currentNode.cost + 1, currentNode));
            }
            if (currentState.TwoC() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.TwoC(), currentNode.cost + 1, currentNode));
            }
            if (currentState.OneMOneC() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.OneMOneC(), currentNode.cost + 1, currentNode));
            }

        }

        if (solutionFound) {
            System.out.println(currentNode.cost);
            System.out.println("");
            System.out.println(numberOfNodesExpanded);
            System.out.println("");
            printPath(currentNode);
        }

    }

    public void printPath(Node solutionNode) {

        if (solutionNode.parent != null) {
            printPath(solutionNode.parent);
        }
        System.out.println(solutionNode.state);

    }

}
