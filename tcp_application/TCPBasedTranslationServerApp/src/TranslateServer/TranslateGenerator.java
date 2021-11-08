package TranslateServer;

public class TranslateGenerator 
{
	public String getMalay (String word)
	{
		if (word == null || word.isEmpty()) 
	    {
	      return "0";
	    }
		
		String translate = "";
		
		if (word == "Good Morning")
		{
			translate = "Selamat Pagi";
		}
		else if(word == "Good Night")
		{
			translate = "Selamat Malam";
		}
		else if(word == "How Are You?")
		{
			translate = "Apa Khabar";
		}
		else if(word == "Thank you")
		{
			translate = "Terima Kasih";
		}
		else if(word == "goodbye")
		{
			translate = "Selamat Tinggal";
		}
		else if(word == "What’s up?")
		{
			translate = "Ada Apa?";
		}
		
		return translate;
	}
	
	public String getArabic (String word)
	{
		if (word == null || word.isEmpty()) 
	    {
	      return "0";
	    }
		
		String translate = "";
		
		if (word == "Good Morning")
		{
			translate = "االخير صباح";
		}
		else if(word == "Good Night")
		{
			translate = "مساؤك طاب";
		}
		else if(word == "How Are You?")
		{
			translate = "حالك؟ كيف";
		}
		else if(word == "Thank you")
		{
			translate = "لك شكرا";
		}
		else if(word == "goodbye")
		{
			translate = "لسالمة مع";
		}
		else if(word == "What’s up?")
		{
			translate = "أخبارك؟ ما";
		}
		
		return translate;
	}
	
	public String getKorean (String word)
	{
		if (word == null || word.isEmpty()) 
	    {
	      return "0";
	    }
		
		String translate = "";
		
		if (word == "Good Morning")
		{
			translate = "ا좋은 아침";
		}
		else if(word == "Good Night")
		{
			translate = "안녕히 주무세요";
		}
		else if(word == "How Are You?")
		{
			translate = "어떻게 지내세요?";
		}
		else if(word == "Thank you")
		{
			translate = "ا감사합니다";
		}
		else if(word == "goodbye")
		{
			translate = "안녕";
		}
		else if(word == "What’s up?")
		{
			translate = "أ뭐야?";
		}
		
		return translate;
	}
}
