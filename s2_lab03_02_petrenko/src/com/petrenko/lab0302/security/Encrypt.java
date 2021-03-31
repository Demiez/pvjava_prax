package com.petrenko.lab0302.security;

import java.util.LinkedList;
import java.util.Random;

public final class Encrypt {

	
	public static String encrypt(String toEncrypt, String key)
	{
		return Jumble(stringToHash(toEncrypt, key), key, true);
	}
	
	public static String encryptIrreversable(String toEncrypt, String key)
	{
		return Jumble(stringToHash(toEncrypt, key), key, false);
	}
	
	public static String encryptIrreversable(String toEncrypt, String key1, String key2)
	{
		return Jumble(stringToHash(toEncrypt, key2),  key1, false);
	}
	
	public static String encryptIrreversable(String toEncrypt, String key1, String key2, int setLength)
	{
		StringBuilder newToEncrypt = new StringBuilder(toEncrypt);
		newToEncrypt.setLength(setLength);
		for(int i = toEncrypt.length(), j = 0; i < setLength; ++i, ++j)
			newToEncrypt.setCharAt(i, (char)(LOWEST_VAL_CHAR + j));
		return Jumble(stringToHash(newToEncrypt.toString(), key2),  key1, false);
	}
	
	public static String decrypt(String toDecrypt, String key) throws BadDecryptException
	{
		return stringFromHash(Unjumble(toDecrypt, key), key);
	}
	
	// приватні змінні тасування
	
	private static final int RAND_VARIATION = 20;
	
	// приватні методи тасування
	
	private static String Jumble(String str, String key, boolean isReversable) {
		long seed = 0;
		if(isReversable)
			seed = JumbleSetSeed(key);
		else
			seed = JumbleSetSeed(str, key);
		return JumblePerform(str, seed);
	}
	
	private static String Unjumble(String str, String key) {
		long seed = JumbleSetSeed(key);
		return UnjumblePerform(str, seed);
	}
	
	private static long JumbleSetSeed(String key) {
		long seed = 0;
		for(int i = 0; i < key.length(); i += 2)
			seed += key.charAt(i);
		return seed;
	}

	private static long JumbleSetSeed(String str, String key) {
		long seed = JumbleSetSeed(str);
		for(int i = 1; i < key.length(); i += 2)
			seed += key.charAt(i);
		return seed;
	}
	
	private static String JumblePerform(String str, long seed) {

		Random rand = new Random();
		rand.setSeed(seed);

		// jumble string
		StringBuilder result = new StringBuilder(str);
		for(int i = 0; i < result.length(); ++i)
			result.setCharAt(i, (char)(result.charAt(i) + rand.nextInt(RAND_VARIATION)));
		
		return result.toString();
	}
	
	private static String UnjumblePerform(String str, long seed) {

		// set up Random
		Random rand = new Random();
		rand.setSeed(seed);
		
		// jumble string
		StringBuilder result = new StringBuilder(str);
		for(int i = 0; i < result.length(); ++i)
			result.setCharAt(i, (char)(result.charAt(i) - rand.nextInt(RAND_VARIATION)));
		
		return result.toString();
	}
	
	// приватні хеш змінні
	
	private static final char LOWEST_VAL_CHAR = ' ';
	private static final char HIGHEST_VAL_CHAR = '~';
	
	// приватні хеш методи
	
	private static char[] generateHash(String key) {
		final int size = (HIGHEST_VAL_CHAR - LOWEST_VAL_CHAR) + 1;
		char[] result = new char[size];
		LinkedList<Integer> indexPool = new LinkedList<Integer>();

		for(int i = size - 1; i >= 0; --i)
			indexPool.push(i);

		Random rand = new Random();
		long seed = 0;
		if(key == null)
			seed = System.currentTimeMillis();
		else
			for(int i = key.length() - 1; i >= 0; --i)
				seed += key.charAt(i);
		rand.setSeed(seed);
		int nextInt;

		for(int i = size - 1; i >= 0; --i)
		{
			nextInt = rand.nextInt(indexPool.size());
			result[i] = (char)(indexPool.get(nextInt) + LOWEST_VAL_CHAR);
			indexPool.remove(nextInt);
		}
		
		return result;
	}
	
	private static char[] generateRHash(char[] hash) {
		char[] rHash = new char[hash.length];
		for(char i = LOWEST_VAL_CHAR; i <= HIGHEST_VAL_CHAR; ++i)
			rHash[toHash(i, hash) - LOWEST_VAL_CHAR] = i;
		return rHash;
	}
	
	private static String stringToHash(String str, String key) {
		char[] hashIndices = generateHash(key);
		StringBuilder result = new StringBuilder();
		for(char c : str.toCharArray())
			result.append(toHash(c, hashIndices));
		return result.toString();
	}
	
	private static String stringFromHash(String str, String key) throws BadDecryptException {
		char[] hashIndices = generateHash(key);
		char[] rHashIndices = generateRHash(hashIndices);
		if(str == null)
			return null;
		StringBuilder result = new StringBuilder();
		for(char c : str.toCharArray())
			result.append(fromHash(c, rHashIndices));
		return result.toString();
	}
	
	private static char toHash(char c, char[] hashIndices) {
		if(c < LOWEST_VAL_CHAR)
			return (char)(c + HIGHEST_VAL_CHAR);
		else if(c > HIGHEST_VAL_CHAR)
			return (char)(c + HIGHEST_VAL_CHAR + LOWEST_VAL_CHAR);
		else
			return hashIndices[c - LOWEST_VAL_CHAR];
	}

	private static char fromHash(char c, char[] rHashIndices) throws BadDecryptException {
		if(c > HIGHEST_VAL_CHAR) {
			if(c < (HIGHEST_VAL_CHAR + LOWEST_VAL_CHAR))
				return (char)(c - HIGHEST_VAL_CHAR);
			else
				return (char)(c - (HIGHEST_VAL_CHAR + LOWEST_VAL_CHAR));
		}
		else if(c >= LOWEST_VAL_CHAR)
			return rHashIndices[c - LOWEST_VAL_CHAR];
		else
			throw new BadDecryptException("Unable to Decrypt String");
	}
}
