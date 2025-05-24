input_file = "german_words_5.txt"
output_file = "german_words_5_unique.txt"

seen = set()

with open(input_file, "r", encoding="utf-8") as infile, open(output_file, "w", encoding="utf-8") as outfile:
    for line in infile:
        if line not in seen:
            outfile.write(line)
            seen.add(line)
