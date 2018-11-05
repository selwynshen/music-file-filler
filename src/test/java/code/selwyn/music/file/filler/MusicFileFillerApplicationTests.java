package code.selwyn.music.file.filler;

import code.selwyn.music.file.filler.handler.MusicNameHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFileFillerApplicationTests {

	@Autowired
	private MusicNameHandler musicNameHandler;

	@Test
	public void contextLoads() throws Exception{
		this.musicNameHandler.handleMusicName("D:\\test\\");
	}

}
