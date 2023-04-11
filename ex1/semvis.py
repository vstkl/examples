from markupsafe import escape
from flask import Flask, request, jsonify, session
from trie import trie_node, add_trie_node, find_trie_node 
import time
import re
import os

wordlist_path = './wamerican.wordlist'

global_wordlist = open(wordlist_path).readlines()

tr = trie_node('')
for word in global_wordlist:
    strip_word = word.strip()
    add_trie_node(tr, strip_word)


app = Flask(__name__)

app.secret_key = 'dljsaklqk24e21cjn!Ew@@dsa5'

@app.route("/sem", methods=['POST'])
def parse_context():
    request_start = time.time()
    words_not_found = 0
    if request.method == "POST":
        raw_string = request.get_data(True, False, True).decode("utf-8")

        print(request.content_type)
        print(request.content_length)

        missing_words = []

        words = list(filter(lambda w: w != '',re.split(r'[\W+]', raw_string.strip())))

        for word in words:
            if word[0].isupper():
                continue
            strip_word = word.strip()
            word_status = find_trie_node(tr, strip_word)
            if word_status[0] == False:
                missing_words.append(strip_word)


        request_end = time.time()
        print("Time elapsed: ", request_end - request_start)
        return jsonify({
                "filter_words": missing_words
            })

@app.route("/sem2", methods=['POST'])
def parse_context2():
    request_start = time.time()
    words_not_found = 0
    if request.method == "POST":
        raw_string = request.get_data(True, False, True).decode("utf-8")

        print(request.content_type)
        print(request.content_length)

        missing_words = []
        words = list(filter(lambda w: w != '',re.split(r'[\W+]', raw_string.strip())))
        
        for index, word in enumerate(words):
            word = word.strip()
            if word[0].isupper():
                continue
            strip_word = word.strip()
            word_status = find_trie_node(tr, strip_word)
            if word_status[0] == False:
                missing_words.append([words[index-1], words[index]])
                missing_words.append([words[index], words[index+1]])


        request_end = time.time()
        print("Time elapsed: ", request_end - request_start)
        return jsonify({
                "filter_words": missing_words
            })

@app.route("/sem3", methods=['POST'])
def parse_context3():
    request_start = time.time()
    words_not_found = 0
    if request.method == "POST":
        raw_string = request.get_data(True, False, True).decode("utf-8")

        print(request.content_type)
        print(request.content_length)

        words_found = 0
        words_not_found
        words = list(filter(lambda w: w != '',re.split(r'[\W+]', raw_string.strip())))
        
        for index, word in enumerate(words):
            word = word.strip()
            if word[0].isupper():
                continue
            strip_word = word.strip()
            word_status = find_trie_node(tr, strip_word)
            if word_status[0] == False:
                words_not_found = 1 + words_not_found
            else:
                words_found = 1 + words_found


        request_end = time.time()
        print("Time elapsed: ", request_end - request_start)
        return jsonify({
                "filter_counts": {
                    "dictwords": words_found,
                    "non-dictwords": words_not_found,
                }
            })


app.run()
