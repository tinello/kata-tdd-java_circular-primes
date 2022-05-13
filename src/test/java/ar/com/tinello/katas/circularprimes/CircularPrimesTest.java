package ar.com.tinello.katas.circularprimes;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularPrimesTest {

    private static CircularPrimes circularPrimes;

    @BeforeClass
    public static void setup() {
        circularPrimes = new CircularPrimes();
    }

    @Test
    public void dado_un_numero_validar_si_es_primo() throws Exception {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(circularPrimes.isPrime(11)).isTrue();
        softly.assertThat(circularPrimes.isPrime(17)).isTrue();
        softly.assertThat(circularPrimes.isPrime(19)).isTrue();
        softly.assertThat(circularPrimes.isPrime(4)).isFalse();
        softly.assertThat(circularPrimes.isPrime(12)).isFalse();
        softly.assertThat(circularPrimes.isPrime(20)).isFalse();
        softly.assertAll();
    }
    
    @Test
    public void dado_un_numero_rotar_el_primer_digito() throws Exception {
    	assertThat(circularPrimes.circularNumber(1234)).isEqualTo(2341);
    }
    
    @Test
    public void dado_un_numero_saber_si_es_circular_primes() throws Exception {
    	SoftAssertions softly = new SoftAssertions();
    	softly.assertThat(circularPrimes.isCircularPrimes(1234)).isFalse();
    	softly.assertThat(circularPrimes.isCircularPrimes(97)).isTrue();
    	softly.assertAll();
    }
    
    @Test
    public void dado_un_numero_encontrar_la_cantidad_de_primos_circulares() throws Exception {
    	SoftAssertions softly = new SoftAssertions();
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(1)).isEqualTo(0);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(10)).isEqualTo(4);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(100)).isEqualTo(13);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(1000)).isEqualTo(25);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(10000)).isEqualTo(33);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(100000)).isEqualTo(43);
    	softly.assertThat(circularPrimes.countCircularPrimesBelow(1000000)).isEqualTo(55);
    	softly.assertAll();
    }
}
