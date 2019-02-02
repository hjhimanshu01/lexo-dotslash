from pyteaser import SummarizeUrl
import sys








if __name__ == '__main__':
 
    if len(sys.argv) < 2:
        print('Usage: python ocr_simple.py image.jpg')
        sys.exit(1)
   
    url = sys.argv[1]
    summaries = SummarizeUrl(url)

    with open('summarized.txt', 'w') as f:
        for item in summaries:
            f.write("%s\n" % item.encode('utf-8') )