package kdata.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Vehicle> list = new ArrayList<>();
		
		list.add(new Car(1, "red", 4));
		list.add(new Vehicle(2, "blue"));
		
		for(int i = 0; i < list.size(); i++){
			Vehicle v = list.get(i);
			//System.out.println(v instanceof Car);
			if(v instanceof Car == true){
				Car c = (Car) v;
				c.getDoor();
			}
		}


		
		/*for(int i = 0; i < list.size(); i++){
			Vehicle v = list.get(i);
			System.out.println(v.getNum());
			System.out.println(v.getColor());
		}*/

		
		
	}

}
