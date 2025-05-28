package LeetCode150.Graph;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        BitSet[] dependencies = new BitSet[numCourses];
        BitSet[] revDependencies = new BitSet[numCourses];

        for ( int i = 0 ; i < numCourses; i++ ) {
            dependencies[i] = new BitSet();
            revDependencies[i] = new BitSet();
        }

        for ( int[] dep : prerequisites) {

            int courseId = dep[0];

            for ( int i = 1; i < dep.length; i++ ) {
                dependencies[courseId].set(dep[i]);
                revDependencies[dep[i]].set(courseId);
            }

        }


        Queue<Integer> courseQueue = new ArrayDeque<>();
        for (int i = 0 ; i < numCourses; i++) {
            if ( dependencies[i].isEmpty() ) {
                courseQueue.add(i);
            }
        }

        int completedCourse = 0 ;

        while ( !courseQueue.isEmpty() ) {

            int courseId = courseQueue.poll();
            completedCourse++;

            revDependencies[courseId].stream().forEach(a -> {
                dependencies[a].clear(courseId);

                if ( dependencies[a].isEmpty() ) {
                    courseQueue.add(a);
                }
            });


        }

        return completedCourse == numCourses;



    }
}
