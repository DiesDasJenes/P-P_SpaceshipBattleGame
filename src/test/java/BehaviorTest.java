import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

public class BehaviorTest {
    private Configuration config;
    private Behavior behavior;
    
    @BeforeEach
    void setUp() {
        config = new Configuration();
        config.setType(ShipType.Corvette);
        behavior = new Behavior(config);
    }

    @Test
    void getHitProbability() {
        // Given
        config.setAV(50);  // Set accuracy value
        config.setEV(50);  // Set evasion value
        
        // When
        int hitProb = behavior.getHitProbability(20);  // Test against lower evasion
        
        // Then
        assertThat(hitProb)
            .as("Hit probability should be between 0 and 100")
            .isBetween(0, 100);
    }
}
