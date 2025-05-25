def entferne_letztes_zeichen(input_pfad, output_pfad):
    with open(input_pfad, 'r', encoding='utf-8') as infile, open(output_pfad, 'w', encoding='utf-8') as outfile:
        for zeile in infile:
            zeile = zeile.rstrip('\n')  # \n entfernen, damit wir das letzte inhaltliche Zeichen bearbeiten
            if zeile:  # nur wenn Zeile nicht leer ist
                neue_zeile = zeile[:-1]  # letztes Zeichen entfernen
            else:
                neue_zeile = ''
            outfile.write(neue_zeile + '\n')

# Beispielaufruf
if __name__ == '__main__':
    input_pfad = 'German-words-1600000-words-multilines.txt'
    output_pfad = 'German-words-1600000-words-multilines_.txt'
    entferne_letztes_zeichen(input_pfad, output_pfad)
