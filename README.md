NLP tool by zhanghc.net
=======

external source
-------
for chinese model, please download specific version from  
3.3.0 http://nlp.stanford.edu/software/stanford-chinese-corenlp-2013-11-12-models.jar  
3.2.0 http://nlp.stanford.edu/software/stanford-chinese-corenlp-2013-06-07-models.jar  
1.3.5 http://nlp.stanford.edu/software/stanford-chinese-corenlp-2013-04-08-models.jar  

and install them into local maven repository  

mvn install:install-file -Dfile=$1 -DgroupId=edu.stanford.nlp -DartifactId=stanford-corenlp -Dversion=$2 -Dpackaging=jar -Dclassifier=chinese-models  

where $1 is the path of chinese model and $2 is the version  
