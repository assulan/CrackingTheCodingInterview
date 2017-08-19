package chapter3;

/**
 * Created by asus on 8/19/17.
 */

import java.util.LinkedList;

class Animal{
    private String type;

    public Animal(String t){
        type = t;
    }

    public String getType() {
        return type;
    }

    public boolean isDog(){
        return type.equals("dog");
    }

    @Override
    public String toString() {
        return type;
    }
}

class AnimalShelter{
    private LinkedList<Animal> animalList;

    public AnimalShelter(){
        animalList = new LinkedList<>();
    }

    public void enqueue(Animal a){
        animalList.add(a);
    }

    public Animal dequeueAny(){
        return animalList.pop();
    }

    public Animal dequeueCat(){
        for (Animal a: animalList){
            if (!a.isDog()){
                animalList.remove(a);
                return a;
            }
        }
        return null;
    }

    public Animal dequeueDog(){
        for(Animal a: animalList){
            if (a.isDog()){
                animalList.remove(a);
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for (Animal a: animalList){
            str += " " + a.toString();
        }
        return str;
    }
}

public class Challenge3_7 {
    public static void main(String[] args){
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Animal("dog"));
        shelter.enqueue(new Animal("dog"));
        shelter.enqueue(new Animal("cat"));
        shelter.enqueue(new Animal("dog"));
        System.out.println(shelter);
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter);
    }
}
