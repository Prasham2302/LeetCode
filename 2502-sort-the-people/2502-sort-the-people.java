class People {
    int height;
    String name;
    People(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<People> people = new ArrayList<>();
        for (int i = 0;i<names.length;i++) 
            people.add(new People(names[i],heights[i]));

        Collections.sort(people, (a,b) -> b.height - a.height);
        String[] sorted = new String[names.length];
        for (int i = 0;i<sorted.length;i++){
            sorted[i] = people.get(i).name;
        }
        return sorted;
        
    }
}