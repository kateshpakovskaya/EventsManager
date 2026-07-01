import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MovieManager;

public class MovieManagerTest {

    @Test
    public void shouldInitEmptyManager() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoviesAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");

        String[] expected = {"Фильм 1: Бладшот", "Фильм 2: Вперёд","Фильм 3: Отель 'Белград'"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLessThanLimitDefault() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");

        String[] expected = {"Фильм 3: Отель 'Белград'",
                "Фильм 2: Вперёд",
                "Фильм 1: Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfEqualToLimitDefault() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");
        manager.add("Фильм 4: Джентльмены");
        manager.add("Фильм 5: Человек-невидимка");

        String[] expected = {"Фильм 5: Человек-невидимка",
                "Фильм 4: Джентльмены",
                "Фильм 3: Отель 'Белград'",
                "Фильм 2: Вперёд",
                "Фильм 1: Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoreThanLimitDefault() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");
        manager.add("Фильм 4: Джентльмены");
        manager.add("Фильм 5: Человек-невидимка");
        manager.add("Фильм 6: Тролли. Мировой тур");
        manager.add("Фильм 7: Номер один");

        String[] expected = {"Фильм 7: Номер один",
                "Фильм 6: Тролли. Мировой тур",
                "Фильм 5: Человек-невидимка",
                "Фильм 4: Джентльмены",
                "Фильм 3: Отель 'Белград'"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimitLessThanMovies() {
        MovieManager manager = new MovieManager(3);
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");
        manager.add("Фильм 4: Джентльмены");

        String[] expected = {"Фильм 4: Джентльмены",
                "Фильм 3: Отель 'Белград'",
                "Фильм 2: Вперёд"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimitMoreThanMovies() {
        MovieManager manager = new MovieManager(7);
        manager.add("Фильм 1: Бладшот");
        manager.add("Фильм 2: Вперёд");
        manager.add("Фильм 3: Отель 'Белград'");
        manager.add("Фильм 4: Джентльмены");
        manager.add("Фильм 5: Человек-невидимка");

        String[] expected = {"Фильм 5: Человек-невидимка",
                "Фильм 4: Джентльмены",
                "Фильм 3: Отель 'Белград'",
                "Фильм 2: Вперёд",
                "Фильм 1: Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
