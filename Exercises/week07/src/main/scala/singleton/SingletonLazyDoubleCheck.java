package singleton;

public class SingletonLazyDoubleCheck {
    private volatile static SingletonLazyDoubleCheck sc = null;

    /* Lazy instantiation means that the singleton object will only be created if it is needed
     * if no call to getInstance occurs in the run time, the code is never run.
     * Advantages: avoids unnecessary execution if not required.
     * Disadvantages: slower at point first required as object has to be instantiated.
     *                care has to be taken to avoid duplicate instantiation in case of multi threads etc.
     */

    private SingletonLazyDoubleCheck() {
    }

    public static SingletonLazyDoubleCheck getInstance() {
        if (sc == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (sc == null) {
                    sc = new SingletonLazyDoubleCheck();
                }
            }
        }
        return sc;
    }
}
