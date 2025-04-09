package map;

import java.util.ArrayList;

public class MyHashMap {
    ArrayList<ArrayList<Integer>> list;
    public MyHashMap(){
        list = new ArrayList<ArrayList<Integer>>();
    }
    public void put(int key, int value){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).get(0)==key){
                list.remove(i);
            }
        }
        ArrayList<Integer> newNode = new ArrayList<>();
        newNode.add(key);
        newNode.add(value);
        list.add(newNode);
    }

    public int get(int key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).get(0)==key){
                return list.get(i).get(1);
            }
        }
        return -1;
    }

    public void remove(int key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).get(0)==key){
                list.remove(i);
            }
        }
    }
    
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        System.out.println("Put [1,1]: "+map);
        map.put(2, 2);
        System.out.println("Put [2,2]: "+map);
        System.out.println("Get 1: "+map.get(1));
        System.out.println("Get 3: "+map.get(3));
        map.put(2, 1);
        System.out.println("Put [2,1]: "+map);
        System.out.println("Get 2: "+map.get(2));
        map.remove(2);
        System.out.println("Remove 2: "+map);
        System.out.println("Get 2: "+map.get(2));
    }
}
