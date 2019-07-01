package br.edu.uniopet.myfavoritegame;

import br.edu.uniopet.myfavoritegame.domain.Game;
import br.edu.uniopet.myfavoritegame.repository.GameRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class MyFavoriteGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFavoriteGameApplication.class, args);
    }

    @Bean
    ApplicationRunner init(GameRepository repository) {
//        return args -> {
//            Stream.of("Devil may cry", "God of war", "Resident evill", "Marvel vs Capcom", "Dragon ball Fighter Z",
//                    "Final fantasy", "Metal slug", "WWE 2K19", "Yugi-oh GX").forEach(nome -> {
//                Game game = new Game();
//                game.setNome(nome);
//                repository.save(game);
//            });
//            repository.findAll().forEach(System.out::println);
//        };

        Game game1 = new Game("Devil may cry", "https://tpucdn.com/reviews/Performance_Analysis/Devil_May_Cry_5/images/small-v1552291371.png");
        Game game2 = new Game("God of war", "https://static.truetrophies.com/boxart/Game_6877.png");
        Game game3 = new Game("Resident evil", "https://i.downloadatoz.com/download/icon2/1/e/2/3d538ace627f077412d5ccf2b7f5b548.jpg");
        Game game4 = new Game("Marvel vs Capcom", "https://bigtallwords.files.wordpress.com/2012/10/marvel-vs-capcom-origins-character-select.jpg?w=256&h=256&crop=1");
        Game game5 = new Game("Dragon ball Fighterz", "https://static.truetrophies.com/boxart/Game_6504.png");
        Game game6 = new Game("Final fantasy", "https://c-sf.smule.com/sf/s64/arr/0a/9b/1f4dd888-70c6-49d5-8bd5-3ed7f41593ca.jpg");
        Game game7 = new Game("Metal slug", "http://www.neo-geo.com/reviews/psx-reviews/mspsx/metalslugcover.gif");
        Game game8 = new Game("WWE 2K19", "https://styles.redditmedia.com/t5_p3r7m/styles/profileIcon_n40il95r0qo11.jpg?width=256&height=256&crop=256:256,smart&s=a02d30476bb0c8bec9193a83d9ab570c62733668");
        Game game9 = new Game("Yugi-oh GX", "https://www.speedrun.com/themes/gxda/cover-256.png");

        repository.saveAll(Arrays.asList(game1, game2, game3, game4, game5,
                game6, game7, game8, game9));

        return null;
    }
}
