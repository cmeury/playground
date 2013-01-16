def combine_anagrams(words)

	# build hash
	hash = Hash.new
	words.each do |word|
		sorted = word.downcase.each_char.to_a.sort.join
		hash[sorted] ? hash[sorted] << word : hash[sorted] = Array[word]
	end

	# format hash
	result = Array.new
	hash.each do |k,v|
		result << v
	end
	return result
end

#puts combine_anagrams(['cars', 'for', 'potatoes', 'racs', 'four', 'scar', 'creams', 'scream'])
