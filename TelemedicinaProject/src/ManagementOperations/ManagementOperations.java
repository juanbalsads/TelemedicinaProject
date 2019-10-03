/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementOperations;

/**
 *
 * @author juanb
 */
public class ManagementOperations {

    /* public void savePopulation(File file, PopulationMouse populationMouse) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(populationMouse);
        } catch (IOException ex) {
            ex.printStackTrace();

        } finally {
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("succesfully saved.");

        }

    }

    public PopulationMouse loadPopulation(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        PopulationMouse populationMouse = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            populationMouse = (PopulationMouse) objectInputStream.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error loading population...");
        } finally {
            objectInputStream.close();
            System.out.println("Succesfully load.");
        }
        return populationMouse;
    }*/
}
