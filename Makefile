BIN = build
SRC = src

PKG_PATH = fr/wieczorek/chess
MAIN_CLASS = fr.wieczorek.chess
JARFILE = chess.jar

CASE = $(BIN)/$(PKG_PATH)/Case.class
CHESS = $(BIN)/$(PKG_PATH)/Chess.class
CONTROLEUR = $(BIN)/$(PKG_PATH)/Controleur.class
ECHIQUIER = $(BIN)/$(PKG_PATH)/Echiquier.class
JCASE = $(BIN)/$(PKG_PATH)/JCase.class
JCHESSFENETRE = $(BIN)/$(PKG_PATH)/JChessFenetre.class
JECHIQUIER = $(BIN)/$(PKG_PATH)/JEchiquier.class
PIECE = $(BIN)/$(PKG_PATH)/Piece.class
ROI = $(BIN)/$(PKG_PATH)/Roi.class
PIECEDRAGLISTENER = $(BIN)/$(PKG_PATH)/PieceDragListener.class

$(BIN):
	if not exist $(BIN) mkdir $(BIN)

$(CHESS): $(SRC)/$(PKG_PATH)/Chess.java $(ECHIQUIER) $(JCHESSFENETRE) $(CONTROLEUR)
	javac -cp $(BIN) -d $(BIN) $<

$(ECHIQUIER): $(SRC)/$(PKG_PATH)/Echiquier.java $(CASE) $(ROI)
	javac -cp $(BIN) -d $(BIN) $<

$(JCHESSFENETRE): $(SRC)/$(PKG_PATH)/JChessFenetre.java $(JECHIQUIER)
	javac -cp $(BIN) -d $(BIN) $<

$(CASE): $(SRC)/$(PKG_PATH)/Case.java $(PIECE)
	javac -cp $(BIN) -d $(BIN) $<

$(PIECE): $(SRC)/$(PKG_PATH)/Piece.java
	javac -cp $(BIN) -d $(BIN) $<

$(ROI): $(SRC)/$(PKG_PATH)/Roi.java
	javac -cp $(BIN) -d $(BIN) $<

$(JECHIQUIER): $(SRC)/$(PKG_PATH)/JEchiquier.java $(JCASE)
	javac -cp $(BIN) -d $(BIN) $<

$(JCASE): $(SRC)/$(PKG_PATH)/JCase.java
	javac -cp $(BIN) -d $(BIN) $<

$(PIECEDRAGLISTENER) $(CONTROLEUR): \
	$(SRC)/$(PKG_PATH)/Controleur.java \
	$(SRC)/$(PKG_PATH)/PieceDragListener.java
	javac -cp $(BIN) -d $(BIN) $^

run: $(CHESS)
	java -cp $(BIN) fr.wieczorek.chess.Chess
