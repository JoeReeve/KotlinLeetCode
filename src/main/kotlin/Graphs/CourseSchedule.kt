package Graphs

class CourseSchedule {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach { pair ->
            preMap[pair[0]] = mutableListOf<Int>()
            preMap[pair[0]]!!.add(pair[1])
        }

        val visited = mutableMapOf<Int, Int>()

        fun dfs(crs: Int): Boolean {
            if (crs in visited) return false
            if (preMap[crs]!!.isEmpty()) return true

            visited.put(crs, crs)
            preMap[crs]!!.forEach { pre ->
                if (!dfs(pre)) return false
            }
            visited.remove(crs)
            preMap[crs] = mutableListOf<Int>()
            return true
        }

        prerequisites.forEach { pair ->
            if (!dfs(pair[0])) return false
        }
        return true
    }

}




