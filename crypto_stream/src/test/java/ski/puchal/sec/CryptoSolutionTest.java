package ski.puchal.sec;

import org.junit.Test;

public class CryptoSolutionTest {

	@Test
	public void test() {
		String ciphertext = "a6f3879fc74e6b4a992b49d3a5c5e477e418da2242685fc9cb5cb2576f19ae28080f6d45f6c8b63df97037edf6e09635fbe13793ab59b5dfc5077a38dc93f55795afde960e208a93696f2f19f691549e54cdfe4839b798d832cdff9b597ea96ee6e7b4f3088a384896644f0ca4349d92ec8176ca4ec8";
		String spaces =     "cfb587c6881b6b09d8654980e080e423ac518922162d079dcb1ef711204beb28181e6355efc6a42de8663beda5a5d871fbac7293ea59f89e8c4b7a3091d2a712dea18ec34d68cbdf3a246679b5d004d91180b70670b9db977fc4ffcc102ae16eada2eda447d87c48912b0249e375cad7add1398449c6b569be2d1c42ac0b928360c9c1ec304821db56e8b8897e7e03eaa0c617895a97df00d7d6fc324a044a1a2f0b7f67e54d7d677d7195291fde61faf211bad0480826cc5c898a42dc19f10a4533cbc4b6aa61433e174ae2efab7b78dec2";
		byte[] c = CryptUtil.hex2byte(ciphertext);
		byte[] s = CryptUtil.hex2byte(spaces);
		for (int i = 0; i < c.length; i++) {
			System.out.print((char) (c[i] ^ s[i] ^ ' '));
		}
	}

}
