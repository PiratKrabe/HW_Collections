import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Linkin on 26.06.2017.
 */
public class Test {

    private static int isInputInt() throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Enter the number");
            }
        }
        return result;
    }

    public static ArrayList<Integer> createOfArrayList() throws Exception {
        Random generator = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of collection ");
        int sizeOfCollection = isInputInt();
        if (sizeOfCollection > 0) {
            ArrayList<Integer> arrayIntList = new ArrayList();
            for (int i = 0; i < sizeOfCollection; i++) {
                arrayIntList.add(generator.nextInt(15));
            }
            System.out.println(arrayIntList);
            return arrayIntList;
        } else {
            return new ArrayList();
        }
    }

    public static ArrayList<Integer> addToCollection(ArrayList<Integer> arrayIntList) throws Exception {
        System.out.println("Please enter integer element: ");
        int intElement = isInputInt();
        System.out.println("Enter position in list to add your element ^");
        int intPosition = isInputInt();
        if ((intPosition >= 0) && (intPosition < arrayIntList.size() - 1)) {
            ListIterator<Integer> listiterator = arrayIntList.listIterator();
            while (listiterator.hasNext()) {
                if (listiterator.nextIndex() == intPosition) {
                    listiterator.add(intElement);
                } else {
                    listiterator.set(listiterator.next() + intElement);
                }
            }
        } else System.err.println("Invalid index");
        System.out.println(arrayIntList);
        return arrayIntList;

    }

    public static ArrayList<Integer> removeFromCollection(ArrayList<Integer> arrayIntList) throws Exception {
        ListIterator<Integer> listiterator = arrayIntList.listIterator();
        System.out.println("Select methods for remove element");
        System.out.println(" 1 - remove element by index");
        System.out.println(" 2 - remove element by value");
        int menuRemoveSelection = isInputInt();
        switch (menuRemoveSelection) {
            case 1:
                System.out.println("Enter index of element ");
                int indexElement = isInputInt();
                while (listiterator.hasNext()) {
                    int indexElementValue = arrayIntList.get(indexElement);
                    if (listiterator.nextIndex() == indexElement) {
                        listiterator.set(listiterator.next() - indexElementValue);
                        listiterator.remove();
                    }
                }
                return arrayIntList;
            case 2:
                System.out.println("Enter element valuse : ");
                int removeElementValue = isInputInt();
                if (arrayIntList.contains(removeElementValue)) {
                    while (listiterator.next() == removeElementValue) {
                        listiterator.remove();
                    }
                    while (listiterator.hasNext()) {
                        listiterator.set(listiterator.next() - removeElementValue);
                    }
                    System.out.println(arrayIntList);
                    return arrayIntList;
                } else {
                    System.out.println("Entered value is missing in collection ");
                }
            default:
                System.err.println("Invalid menu selection");
                return arrayIntList;
        }
    }

    public static void findValueInArrayList(ArrayList<Integer> arrayIntList) throws Exception {
        System.out.println("Enter your number: ");
        int valueFindIntNumber = isInputInt();
        int countOfFindNumbers = 0;
        for (int i = 0; i < arrayIntList.size(); i++) {
            if (arrayIntList.get(i).equals(valueFindIntNumber)) {
                System.out.println("Your element in position # " + i);
                countOfFindNumbers++;
            }
        }
        if (countOfFindNumbers != 0)
            System.out.println("The entered number occurs " + countOfFindNumbers + " times");
        else System.out.println("Collections not have your number");
    }

    public static int findElementFromIndex(ArrayList<Integer> arrayIntList) throws Exception {
        System.out.println("Enter index of find element : ");
        int indexFindElement = isInputInt();
        if (indexFindElement > arrayIntList.size() - 1) {
            System.out.println("Wrong index.");
        } else {
            System.out.println("Your element in position # " + indexFindElement + " have value" + arrayIntList.get(indexFindElement));
        }
        return arrayIntList.get(indexFindElement);
    }

    public static int maxElementInCollection(ArrayList<Integer> arrayIntList) throws Exception {
        System.out.println("Max element in Collections: " + Collections.max(arrayIntList));
        return Collections.max(arrayIntList);
    }

    public static int minElementInCollection(ArrayList<Integer> arrayIntList) throws Exception {
        System.out.println("Minimal element in Collections : " + Collections.min(arrayIntList));
        return Collections.min(arrayIntList);
    }

    public static double avgInCollection(ArrayList<Integer> arrayIntList) {
        int sumOfArrayElements = 0;
        for (int index : arrayIntList) {
            sumOfArrayElements = sumOfArrayElements + index;
        }
        System.out.println("Average of collection = " + (double) (sumOfArrayElements / arrayIntList.size()));
        return (double) sumOfArrayElements / arrayIntList.size();
    }

    public static boolean menuSelection(ArrayList<Integer> arrayIntList) throws Exception {
        if (arrayIntList.size() > 0) {
            System.out.println("=================================================");
            System.out.println("Please choice number of menu ");
            System.out.println("=================================================");
            System.out.println(" 1 - Add element to Collection");
            System.out.println(" 2 - Remove element of Collection");
            System.out.println(" 3 - Find element in Collection by value");
            System.out.println(" 4 - Find element in Collection by index");
            System.out.println(" 5 - Max element in Collection");
            System.out.println(" 6 - Min element in Collection");
            System.out.println(" 7 - Average of Collection");
            System.out.println(" 8 - Show Collection in display");
            System.out.println(" 0 - Exit");
            System.out.println("=================================================");
            System.out.println("Collection :" + arrayIntList);
            System.out.println("=================================================");
            int switchMenu = isInputInt();
            switch (switchMenu) {
                case 1:
                    addToCollection(arrayIntList);
                    return true;
                case 2:
                    removeFromCollection(arrayIntList);
                    return true;
                case 3:
                    findValueInArrayList(arrayIntList);
                    return true;
                case 4:
                    findElementFromIndex(arrayIntList);
                    return true;
                case 5:
                    maxElementInCollection(arrayIntList);
                    return true;
                case 6:
                    minElementInCollection(arrayIntList);
                    return true;
                case 7:
                    avgInCollection(arrayIntList);
                    return true;
                case 8:
                    System.out.println("Your Collection is : " + arrayIntList);
                    return true;
                case 0:
                    return false;
                default:
                    System.out.println("Invalid menu number");
                    return true;
            }
        } else {
            System.err.println("Invalid size of array");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList(createOfArrayList());
        while (menuSelection(arrayList)) {
            menuSelection(arrayList);
        }
    }
}
