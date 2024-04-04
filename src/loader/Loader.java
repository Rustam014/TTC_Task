package loader;

public interface Loader<T> {
    T load(String path) throws Exception;
}
