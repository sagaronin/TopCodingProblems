package trees;

import java.util.*;

public class PackageInstaller {

    public static List<String> installOrder(Map<String, List<String>> dependencies) {
        Map<String, Integer> indegree = new HashMap<>(); // Stores indegree of each package
        List<String> result = new ArrayList<>(); // Stores installation order

        // Initialize indegree for all packages
        for (String packageName : dependencies.keySet()) {
            indegree.put(packageName, 0);
        }

        // Count indegree for each package based on dependencies
        for (Map.Entry<String, List<String>> entry : dependencies.entrySet()) {
            for (String dependentPackage : entry.getValue()) {
                indegree.put(dependentPackage, indegree.getOrDefault(dependentPackage,0) + 1);
            }
        }

        // Use a queue to process packages with indegree 0 (no dependencies)
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        // Perform topological sort to find installation order
        while (!queue.isEmpty()) {
            String packageName = queue.poll();
            result.add(packageName);

            if (dependencies.containsKey(packageName)) {
                for (String dependentPackage : dependencies.get(packageName)) {
                    indegree.put(dependentPackage, indegree.get(dependentPackage) - 1);
                    if (indegree.get(dependentPackage) == 0) {
                        queue.add(dependentPackage);
                    }
                }
            }
        }

        // Check for cycles in dependencies
        if (result.size() != dependencies.size()) {
            throw new RuntimeException("Cycle detected in package dependencies");
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> dependencies = new HashMap<>();
        dependencies.put("A", Arrays.asList("B", "C", "D"));
        dependencies.put("B", Arrays.asList("F"));
        dependencies.put("D", Arrays.asList("E"));
        // Add more dependencies as needed

        List<String> installOrder = installOrder(dependencies);
        System.out.println("Installation order: " + installOrder);
    }
}
