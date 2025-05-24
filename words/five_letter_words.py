# filter_five_letter_words.py

input_file = "simple_wordlist.txt"          # Ursprüngliche Datei mit allen Wörtern
output_file = "simple_words_5.txt"       # Neue Datei mit nur 5-Buchstaben-Wörtern

with open(input_file, "r", encoding="utf-8") as infile, open(output_file, "w", encoding="utf-8") as outfile:
    for line in infile:
        word = line.strip().strip('"')  # Entfernt Anführungszeichen und Zeilenumbruch
        if len(word) == 5:
            outfile.write(f'"{word}"\n')  # Schreibt es im gleichen Format zurück
