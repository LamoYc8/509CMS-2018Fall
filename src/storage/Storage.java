package storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Model;

public class Storage {
	private String fileName;

	public Storage(String fileName) {
		this.fileName = fileName;
	}

	public void saveToFile(Model m) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

			oos.writeObject(m);

			oos.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Model getObjectFromFile() throws IOException, ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

			Model m = (Model)ois.readObject();

			ois.close();
			
			return m;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
