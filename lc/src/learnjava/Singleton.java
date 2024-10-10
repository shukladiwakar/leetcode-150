package learnjava;

final public class Singleton {


    Singleton singleton;

    public void Singleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
    }

    public Singleton getSingletonInstance() {
        return this.singleton;
    }
}
