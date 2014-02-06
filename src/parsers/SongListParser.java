package parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import logging.Log;
import string_operations.StrOps;

public class SongListParser {
	String list_location;
	Log ll;
	public SongListParser(String list_location, Log ll){
		this.list_location = list_location;
		this.ll = ll;
	}
	
	public ArrayList<ArrayList<String>> load_and_parse(){
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(list_location));
			String line = br.readLine();
			while(line != null){
				if(line.length() > 0){
					if(line.charAt(0) != '#'){
						String artist = StrOps.getDilineatedSubstring(line, ":", 0, false);
						line = line.substring(artist.length()+1);
						artist = StrOps.trimString(artist);
						String name = StrOps.getDilineatedSubstring(line, "-", 0, false);
						line = line.substring(name.length()+1);
						name = StrOps.trimString(name);
						String link = StrOps.trimString(line);
						ArrayList<String> song = new ArrayList<String>();
						song.add(artist);
						song.add(name);
						song.add(link);
						output.add(song);
					}
				}
				line = br.readLine();
			}
			br.close();
		} catch(IOException e){
			ll.write(1, "IOError with file at " + list_location);
			System.exit(-1);
		}
		return output;
	}
}
