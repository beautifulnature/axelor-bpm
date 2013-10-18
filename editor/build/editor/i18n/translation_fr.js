/*******************************************************************************
 * Signavio Core Components
 * Copyright (C) 2012  Signavio GmbH
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
if(!ORYX) var ORYX = {};

if(!ORYX.I18N) ORYX.I18N = {};

ORYX.I18N.Language = "fr_fr"; //Pattern <ISO language code>_<ISO country code> in lower case!

if(!ORYX.I18N.Oryx) ORYX.I18N.Oryx = {};

ORYX.I18N.Oryx.title		= "AxelorBPM";
ORYX.I18N.Oryx.noBackendDefined	= "Attention! \nAucun Backend défini.\n Le model n'a pas pu être chargé. Try to load a configuration with a save plugin.";
ORYX.I18N.Oryx.pleaseWait 	= "Merci de patienter pendant le chargement...";
ORYX.I18N.Oryx.notLoggedOn = "Vous n'êtes pas connecté";
ORYX.I18N.Oryx.editorOpenTimeout = "L'éditeur ne semble pas encore avoir démarré. Merci de vérifier qu'aucun blocage de pop-up n'est actif ou que l'ouverture de pop-up est autorisé pour ce site. Aucune annonce commerciale ne sera diffusée sur ce site.";

if(!ORYX.I18N.AddDocker) ORYX.I18N.AddDocker = {};

ORYX.I18N.AddDocker.group = "Docker";
ORYX.I18N.AddDocker.add = "Add Docker";
ORYX.I18N.AddDocker.addDesc = "Add a Docker to an edge, by clicking on it";
ORYX.I18N.AddDocker.del = "Delete Docker";
ORYX.I18N.AddDocker.delDesc = "Delete a Docker";

if(!ORYX.I18N.Arrangement) ORYX.I18N.Arrangement = {};

ORYX.I18N.Arrangement.groupZ = "Z-Order";
ORYX.I18N.Arrangement.btf = "Mettre au premier plan";
ORYX.I18N.Arrangement.btfDesc = "Mettre au premier plan";
ORYX.I18N.Arrangement.btb = "Mettre en arrière plan";
ORYX.I18N.Arrangement.btbDesc = "Mettre en arrière plan";
ORYX.I18N.Arrangement.bf = "Avancer";
ORYX.I18N.Arrangement.bfDesc = "Avancer";
ORYX.I18N.Arrangement.bb = "Reculer";
ORYX.I18N.Arrangement.bbDesc = "Reculer";
ORYX.I18N.Arrangement.groupA = "Aligner";
ORYX.I18N.Arrangement.ab = "Alignen en Bas";
ORYX.I18N.Arrangement.abDesc = "Bas";
ORYX.I18N.Arrangement.am = "Alignment au Milieu";
ORYX.I18N.Arrangement.amDesc = "Milieu";
ORYX.I18N.Arrangement.at = "Alignment en Haut";
ORYX.I18N.Arrangement.atDesc = "Haut";
ORYX.I18N.Arrangement.al = "Alignment à Gauche";
ORYX.I18N.Arrangement.alDesc = "Gauche";
ORYX.I18N.Arrangement.ac = "Alignment au Centre";
ORYX.I18N.Arrangement.acDesc = "Centre";
ORYX.I18N.Arrangement.ar = "Alignment à Droite";
ORYX.I18N.Arrangement.arDesc = "Droite";
ORYX.I18N.Arrangement.as = "Alignment à taille égale";
ORYX.I18N.Arrangement.asDesc = "Taille égale";

if(!ORYX.I18N.Edit) ORYX.I18N.Edit = {};

ORYX.I18N.Edit.group = "Editer";
ORYX.I18N.Edit.cut = "Couper";
ORYX.I18N.Edit.cutDesc = "Couper la sélection dans le presse-papier AxelorBPM";
ORYX.I18N.Edit.copy = "Copier";
ORYX.I18N.Edit.copyDesc = "Couper la sélection dans le presse-papier AxelorBPM";
ORYX.I18N.Edit.paste = "Coller";
ORYX.I18N.Edit.pasteDesc = "Coller le presse-paier AxelorBPM dans l'espace de travail";
ORYX.I18N.Edit.del = "Supprimer";
ORYX.I18N.Edit.delDesc = "Supprimer les formes sélectionnées";

if(!ORYX.I18N.EPCSupport) ORYX.I18N.EPCSupport = {};

ORYX.I18N.EPCSupport.group = "EPC";
ORYX.I18N.EPCSupport.exp = "Exporter EPC";
ORYX.I18N.EPCSupport.expDesc = "Exporter le diagramme au format EPML";
ORYX.I18N.EPCSupport.imp = "Importer EPC";
ORYX.I18N.EPCSupport.impDesc = "Importer un fichier EPML";
ORYX.I18N.EPCSupport.progressExp = "Export en cours...";
ORYX.I18N.EPCSupport.selectFile = "Sélectionner un fichier EPML (.empl) à importer.";
ORYX.I18N.EPCSupport.file = "Fichier";
ORYX.I18N.EPCSupport.impPanel = "Importer un fichier EPML";
ORYX.I18N.EPCSupport.impBtn = "Importer";
ORYX.I18N.EPCSupport.close = "Fermer";
ORYX.I18N.EPCSupport.error = "Erreur";
ORYX.I18N.EPCSupport.progressImp = "Import en cours...";

if(!ORYX.I18N.ERDFSupport) ORYX.I18N.ERDFSupport = {};

ORYX.I18N.ERDFSupport.exp = "Exporter en eRDF";
ORYX.I18N.ERDFSupport.expDesc = "Exporter en eRDF";
ORYX.I18N.ERDFSupport.imp = "Importer un fichier eRDF";
ORYX.I18N.ERDFSupport.impDesc = "Importer un fichier eRDF";
ORYX.I18N.ERDFSupport.impFailed = "La requête d'import du fichier eRDF a échoué.";
ORYX.I18N.ERDFSupport.impFailed2 = "Une erreur est survenue durant l'import! <br/>Veuillez vérifier le message d'erreur: <br/><br/>";
ORYX.I18N.ERDFSupport.error = "Erreur";
ORYX.I18N.ERDFSupport.noCanvas = "Le document XML ne contient aucun espace de travail!";
ORYX.I18N.ERDFSupport.noSS = "Aucune liste d'attributs n'a été définie dans l'espace de travail de l'éditeur de processus AxelorBPM !";
ORYX.I18N.ERDFSupport.wrongSS = "La liste d'attributs fournis ne peut s'insérer dans l'éditeur actuel!";
ORYX.I18N.ERDFSupport.selectFile = "Sélectionner un fichier eRDF (.xml) ou renseigner l'eRDF pour l'importer!";
ORYX.I18N.ERDFSupport.file = "Fichier";
ORYX.I18N.ERDFSupport.impERDF = "Importer un fichier eRDF";
ORYX.I18N.ERDFSupport.impBtn = "Importer";
ORYX.I18N.ERDFSupport.impProgress = "Importation en cours...";
ORYX.I18N.ERDFSupport.close = "Fermer";
ORYX.I18N.ERDFSupport.deprTitle = "Souhaitez-vous vraiment exporter au format eRDF ?";
ORYX.I18N.ERDFSupport.deprText = "L'export au format eRDF n'est plus recommandé car ce format ne sera plus maintenu dans les versions ultérieurs de l'Editeur de Processus AxelorBPM. Dans la mesure du possible, il est recommandé d'exporter au format JSON. Souhaitez-vous tout de même continuer l'export dans ce format ?";

if(!ORYX.I18N.jPDLSupport) ORYX.I18N.jPDLSupport = {};

ORYX.I18N.jPDLSupport.group = "ExecBPMN";
ORYX.I18N.jPDLSupport.exp = "Exporter en jPDL";
ORYX.I18N.jPDLSupport.expDesc = "Exporter en jPDL";
ORYX.I18N.jPDLSupport.imp = "Importer en jPDL";
ORYX.I18N.jPDLSupport.impDesc = "Importer le fichier jPDL";
ORYX.I18N.jPDLSupport.impFailedReq = "Request for import of jPDL failed.";
ORYX.I18N.jPDLSupport.impFailedJson = "La transformation en jPDL a échoué.";
ORYX.I18N.jPDLSupport.impFailedJsonAbort = "L'import a échoué.";
ORYX.I18N.jPDLSupport.loadSseQuestionTitle = "La liste d'attributs jBPM doit être chargé."; 
ORYX.I18N.jPDLSupport.loadSseQuestionBody = "Dans le but d'importer un fichier jPDL, la liste d'attributs doit être chargé. Est-ce que vous souhaitez continuer ?";
ORYX.I18N.jPDLSupport.expFailedReq = "La demande d'export du modèle a échouée.";
ORYX.I18N.jPDLSupport.expFailedXml = "L'export au format jPDL a échoué. Rapport d'export: ";
ORYX.I18N.jPDLSupport.error = "Erreur";
ORYX.I18N.jPDLSupport.selectFile = "Sélectionner un fichier jPDL (.xml) ou renseigner le jPDL pour l'importer!";
ORYX.I18N.jPDLSupport.file = "Fichier";
ORYX.I18N.jPDLSupport.impJPDL = "Importer un fichier jPDL";
ORYX.I18N.jPDLSupport.impBtn = "Importer";
ORYX.I18N.jPDLSupport.impProgress = "Importation en cours...";
ORYX.I18N.jPDLSupport.close = "Fermer";

if(!ORYX.I18N.Save) ORYX.I18N.Save = {};

ORYX.I18N.Save.group = "Fichier";
ORYX.I18N.Save.save = "Enregistrer";
ORYX.I18N.Save.saveDesc = "Enregistrer";
ORYX.I18N.Save.saveAs = "Enregistrer sous...";
ORYX.I18N.Save.saveAsDesc = "Enregistrer sous...";
ORYX.I18N.Save.unsavedData = "Des données ne sont pas encore enregistrées, pensez à sauvegarder avant de quitter l'application ou vous risquez de perdre vos modifications!";
ORYX.I18N.Save.newProcess = "Nouveau Processus";
ORYX.I18N.Save.saveAsTitle = "Enregistrer sous...";
ORYX.I18N.Save.saveBtn = "Enregistrer";
ORYX.I18N.Save.close = "Fermer";
ORYX.I18N.Save.savedAs = "Enregistrer sous";
ORYX.I18N.Save.saved = "Enregistrement effectué!";
ORYX.I18N.Save.failed = "L'enregistrement a échoué.";
ORYX.I18N.Save.noRights = "Vous n'êtes pas autorisé à enregistrer des modifications.";
ORYX.I18N.Save.saving = "Enregistrement en cours";
ORYX.I18N.Save.saveAsHint = "Le diagramme du processus est enregistré sous:";

if(!ORYX.I18N.File) ORYX.I18N.File = {};

ORYX.I18N.File.group = "Fichier";
ORYX.I18N.File.print = "Imprimer";
ORYX.I18N.File.printDesc = "Imprimer le modèle actif";
ORYX.I18N.File.pdf = "Exporter en PDF";
ORYX.I18N.File.pdfDesc = "Exporter en PDF";
ORYX.I18N.File.info = "Info";
ORYX.I18N.File.infoDesc = "Info";
ORYX.I18N.File.genPDF = "Génération du PDF en cours";
ORYX.I18N.File.genPDFFailed = "La génération du PDF a échoué.";
ORYX.I18N.File.printTitle = "Imprimer";
ORYX.I18N.File.printMsg = "La fonction d'impression peut ne pas fonctionner correctement. Nous vous recommandons d'utiliser l'export PDF pour imprimer votre diagramme. Souhaitez-vous continuer l'impression ?";

if(!ORYX.I18N.Grouping) ORYX.I18N.Grouping = {};

ORYX.I18N.Grouping.grouping = "Grouper";
ORYX.I18N.Grouping.group = "Grouper";
ORYX.I18N.Grouping.groupDesc = "Grouper les formes sélectionnées";
ORYX.I18N.Grouping.ungroup = "Dissocier";
ORYX.I18N.Grouping.ungroupDesc = "Dissocie les formes sélectionnées du groupe auquel elles étaient rattachées.";

if(!ORYX.I18N.Loading) ORYX.I18N.Loading = {};

ORYX.I18N.Loading.waiting ="Merci de patienter...";

if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};

ORYX.I18N.PropertyWindow.name = "Nom";
ORYX.I18N.PropertyWindow.value = "Valeur";
ORYX.I18N.PropertyWindow.selected = "sélectionné";
ORYX.I18N.PropertyWindow.clickIcon = "Clique sur l'Icône";
ORYX.I18N.PropertyWindow.add = "Ajouter";
ORYX.I18N.PropertyWindow.rem = "Supprimer";
ORYX.I18N.PropertyWindow.complex = "Editeur de type complexe";
ORYX.I18N.PropertyWindow.text = "Editeur de type texte";
ORYX.I18N.PropertyWindow.ok = "Ok";
ORYX.I18N.PropertyWindow.cancel = "Annuler";
ORYX.I18N.PropertyWindow.dateFormat = "d/m/y";

if(!ORYX.I18N.ShapeMenuPlugin) ORYX.I18N.ShapeMenuPlugin = {};

ORYX.I18N.ShapeMenuPlugin.drag = "Glisser";
ORYX.I18N.ShapeMenuPlugin.clickDrag = "Cliquer ou glisser";
ORYX.I18N.ShapeMenuPlugin.morphMsg = "Forme morphologique";

if(!ORYX.I18N.SyntaxChecker) ORYX.I18N.SyntaxChecker = {};

ORYX.I18N.SyntaxChecker.group = "Vérification";
ORYX.I18N.SyntaxChecker.name = "Vérificateur de syntaxe";
ORYX.I18N.SyntaxChecker.desc = "Vérifie la syntaxe";
ORYX.I18N.SyntaxChecker.noErrors = "Aucune erreur de syntaxe détectée.";
ORYX.I18N.SyntaxChecker.invalid = "Réponse invalide du serveur.";
ORYX.I18N.SyntaxChecker.checkingMessage = "Vérification en cours...";

if(!ORYX.I18N.Undo) ORYX.I18N.Undo = {};

ORYX.I18N.Undo.group = "Annuler";
ORYX.I18N.Undo.undo = "Annuler";
ORYX.I18N.Undo.undoDesc = "Annuler la dernière action.";
ORYX.I18N.Undo.redo = "Rétablir";
ORYX.I18N.Undo.redoDesc = "Rétablir la dernière action annulée.";

if(!ORYX.I18N.View) ORYX.I18N.View = {};

ORYX.I18N.View.group = "Zoom";
ORYX.I18N.View.zoomIn = "Zoomer";
ORYX.I18N.View.zoomInDesc = "Zoomer sur le model.";
ORYX.I18N.View.zoomOut = "DéZoomer";
ORYX.I18N.View.zoomOutDesc = "DéZoomer sur le model.";
ORYX.I18N.View.zoomStandard = "Zoom Standard";
ORYX.I18N.View.zoomStandardDesc = "Zoomer à la taille standard.";
ORYX.I18N.View.zoomFitToModel = "Zoom ajusté au modèle";
ORYX.I18N.View.zoomFitToModelDesc = "Ajuster le Zoom à la taille du modèle.";

/** New Language Properties: 08.12.2008 */

ORYX.I18N.PropertyWindow.title = "Propriétés";

if(!ORYX.I18N.ShapeRepository) ORYX.I18N.ShapeRepository = {};
ORYX.I18N.ShapeRepository.title = "Répertoire de formes";

ORYX.I18N.Save.dialogDesciption = "Merci de saisir un nom, une description et un commentaire.";
ORYX.I18N.Save.dialogLabelTitle = "Titre";
ORYX.I18N.Save.dialogLabelDesc = "Description";
ORYX.I18N.Save.dialogLabelType = "Type";
ORYX.I18N.Save.dialogLabelComment = "Commentaire de révision";

Ext.MessageBox.buttonText.yes = "Oui";
Ext.MessageBox.buttonText.no = "Non";
Ext.MessageBox.buttonText.cancel = "Annuler";
Ext.MessageBox.buttonText.ok = "OK";

if(!ORYX.I18N.Perspective) ORYX.I18N.Perspective = {};
ORYX.I18N.Perspective.no = "Aucune perspective"
ORYX.I18N.Perspective.noTip = "Décharger la perspective courante"

/** New Language Properties: 21.04.2009 */
ORYX.I18N.JSONSupport = {
    imp: {
        name: "Importer un fichier JSON",
        desc: "Importer un modèle JSON",
        group: "Exporter",
        selectFile: "Sélectionner un fichier JSON(.json) ou renseigner le JSON pour l'importer!",
        file: "Fichier",
        btnImp: "Importer",
        btnClose: "Fermer",
        progress: "Import en cours...",
        syntaxError: "Erreur de syntaxe"
    },
    exp: {
        name: "Exporter en JSON",
        desc: "Export du modèle actif en JSON",
        group: "Exporter"
    }
};

/** New Language Properties: 09.05.2009 */
if(!ORYX.I18N.JSONImport) ORYX.I18N.JSONImport = {};

ORYX.I18N.JSONImport.title = "Import JSON";
ORYX.I18N.JSONImport.wrongSS = "a liste d'attributs du fichier importé ({0}) ne correspond pas à la lste d'attributs chargés ({1})."

/** New Language Properties: 14.05.2009 */
if(!ORYX.I18N.RDFExport) ORYX.I18N.RDFExport = {};
ORYX.I18N.RDFExport.group = "Exporter";
ORYX.I18N.RDFExport.rdfExport = "Exporter en RDF";
ORYX.I18N.RDFExport.rdfExportDescription = "Export du modèle actif au format XML en fonction de ce qui est défini dans le fichier RDF (Resource Description Framework).";

/** New Language Properties: 15.05.2009*/
if(!ORYX.I18N.SyntaxChecker.BPMN) ORYX.I18N.SyntaxChecker.BPMN={};
ORYX.I18N.SyntaxChecker.BPMN_NO_SOURCE = "Une extrémité doit avoir une source.";
ORYX.I18N.SyntaxChecker.BPMN_NO_TARGET = "Une extrémité doit avoir une cible.";
ORYX.I18N.SyntaxChecker.BPMN_DIFFERENT_PROCESS = "Le noeud source et le noeud cible doivent être contenus dans le même processus.";
ORYX.I18N.SyntaxChecker.BPMN_SAME_PROCESS = "Le noeud source et le noeud cible doivent être contenus dans des processus différents.";
ORYX.I18N.SyntaxChecker.BPMN_FLOWOBJECT_NOT_CONTAINED_IN_PROCESS = "Un objet flux doit être contenu dans un processus.";
ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITHOUT_INCOMING_CONTROL_FLOW = "Un évènement Fin doit posséder un flux entrant.";
ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITHOUT_OUTGOING_CONTROL_FLOW = "Un évènement de Départ doit posséder un flux sortant.";
ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITH_INCOMING_CONTROL_FLOW = "Un évènement de Départ ne doit pas contenir de flux entrant.";
ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITH_INCOMING_CONTROL_FLOW = "Les évènements intermédiaires rattachés ne doivent pas avoir de flux entrants.";
ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITHOUT_OUTGOING_CONTROL_FLOW = "Les évènements intermédiaires doivent avoir exactement un flux sortant.";
ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITH_OUTGOING_CONTROL_FLOW = "Un évènement de Fin ne doit pas contenir de flux sortant.";
ORYX.I18N.SyntaxChecker.BPMN_EVENTBASEDGATEWAY_BADCONTINUATION = "Les gateways basées sur des évènements ne doivent pas être suivies par d'autres gateways ou sous-processus.";
ORYX.I18N.SyntaxChecker.BPMN_NODE_NOT_ALLOWED = "Ce type de noeud n'est pas autorisé.";

if(!ORYX.I18N.SyntaxChecker.IBPMN) ORYX.I18N.SyntaxChecker.IBPMN={};
ORYX.I18N.SyntaxChecker.IBPMN_NO_ROLE_SET = "Les interactions doivent avoir un rôle d'émetteur et de receveur défini.";
ORYX.I18N.SyntaxChecker.IBPMN_NO_INCOMING_SEQFLOW = "Ce noeud doit avoir un flux entrant.";
ORYX.I18N.SyntaxChecker.IBPMN_NO_OUTGOING_SEQFLOW = "Ce noeud doit avoir un flux sortant.";

if(!ORYX.I18N.SyntaxChecker.InteractionNet) ORYX.I18N.SyntaxChecker.InteractionNet={};
ORYX.I18N.SyntaxChecker.InteractionNet_SENDER_NOT_SET = "Emetteur non défini";
ORYX.I18N.SyntaxChecker.InteractionNet_RECEIVER_NOT_SET = "Receveur non défini";
ORYX.I18N.SyntaxChecker.InteractionNet_MESSAGETYPE_NOT_SET = "Type de message non défini";
ORYX.I18N.SyntaxChecker.InteractionNet_ROLE_NOT_SET = "Rôle non défini";

if(!ORYX.I18N.SyntaxChecker.EPC) ORYX.I18N.SyntaxChecker.EPC={};
ORYX.I18N.SyntaxChecker.EPC_NO_SOURCE = "Chaque extrémité doit avoir une source.";
ORYX.I18N.SyntaxChecker.EPC_NO_TARGET = "Chaque extrémité doit avoir une sortie.";
ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED = "Un noeud doit être connecté avec des extrémités.";
ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED_2 = "Un noeud doit être connecté avec des extrémités.";
ORYX.I18N.SyntaxChecker.EPC_TOO_MANY_EDGES = "Ce noeud est connecté avec trop d'extrémités.";
ORYX.I18N.SyntaxChecker.EPC_NO_CORRECT_CONNECTOR = "Ce noeud n'est pas un connecteur adéquat.";
ORYX.I18N.SyntaxChecker.EPC_MANY_STARTS = "Il ne doit y avoir qu'un seul élément de Départ.";
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_OR = "Aucune fonction ne doit être positionnées après une séparation OR/XOR.";
ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_OR = "Aucun processus/interfaces ne doit être positionnées après une séparation OR/XOR.";
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_FUNCTION =  "Aucune fonction ne doit être placée après une autre fonction.";
ORYX.I18N.SyntaxChecker.EPC_EVENT_AFTER_EVENT =  "Aucun évènement ne doit être placé après un autre évènement.";
ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_FUNCTION =  "Aucun processus/interface ne doit être placé après une fonction.";
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_PI =  "There must be no function after a process interface.";
ORYX.I18N.SyntaxChecker.EPC_SOURCE_EQUALS_TARGET = "Une extrémité doit connecter deux noeuds distincts."

if(!ORYX.I18N.SyntaxChecker.PetriNet) ORYX.I18N.SyntaxChecker.PetriNet={};
ORYX.I18N.SyntaxChecker.PetriNet_NOT_BIPARTITE = "Le graphique n'est pas bipartite.";
ORYX.I18N.SyntaxChecker.PetriNet_NO_LABEL = "Le libellé n'a pas été défini pour la transition";
ORYX.I18N.SyntaxChecker.PetriNet_NO_ID = "Il existe un noeud sans Id.";
ORYX.I18N.SyntaxChecker.PetriNet_SAME_SOURCE_AND_TARGET = "Deux flux relationnels ont le même source et la même cible.";
ORYX.I18N.SyntaxChecker.PetriNet_NODE_NOT_SET = "Un noeud n'est pas défini pour être un flux relationnel.";

/** New Language Properties: 02.06.2009*/
ORYX.I18N.Edge = "Edge";
ORYX.I18N.Node = "Node";

/** New Language Properties: 03.06.2009*/
ORYX.I18N.SyntaxChecker.notice = "Placer votre souris sur l'icône croix rouge pour voir le message d'erreur.";

/** New Language Properties: 05.06.2009*/
if(!ORYX.I18N.RESIZE) ORYX.I18N.RESIZE = {};
ORYX.I18N.RESIZE.tipGrow = "Augmenter la taille de l'espace de tavail:";
ORYX.I18N.RESIZE.tipShrink = "Réduire la taille de l'espace de travail:";
ORYX.I18N.RESIZE.N = "Haut";
ORYX.I18N.RESIZE.W = "Gauche";
ORYX.I18N.RESIZE.S ="Bas";
ORYX.I18N.RESIZE.E ="Droite";

/** New Language Properties: 15.07.2009*/
if(!ORYX.I18N.Layouting) ORYX.I18N.Layouting ={};
ORYX.I18N.Layouting.doing = "Apercu en cours...";

/** New Language Properties: 18.08.2009*/
ORYX.I18N.SyntaxChecker.MULT_ERRORS = "Erreurs multiples";

/** New Language Properties: 08.09.2009*/
if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};
ORYX.I18N.PropertyWindow.oftenUsed = "Fréquemment utilisés";
ORYX.I18N.PropertyWindow.moreProps = "Plus de Propriétés";

/** New Language Properties 01.10.2009 */
if(!ORYX.I18N.SyntaxChecker.BPMN2) ORYX.I18N.SyntaxChecker.BPMN2 = {};

ORYX.I18N.SyntaxChecker.BPMN2_DATA_INPUT_WITH_INCOMING_DATA_ASSOCIATION = "Une entrée de données ne doit pas être rattachée à une association de données entrantes.";
ORYX.I18N.SyntaxChecker.BPMN2_DATA_OUTPUT_WITH_OUTGOING_DATA_ASSOCIATION = "Une sortie de données ne doit pas être rattachée à une association de données sortantes.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_TARGET_WITH_TOO_MANY_INCOMING_SEQUENCE_FLOWS = "Les cibles des gateways basées sur des évènements doivent seulement aavoir un flux entrant.";

/** New Language Properties 02.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_OUTGOING_SEQUENCE_FLOWS = "Une gateway basée sur un évènement doit avoir deux ou plus flux sortant.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_EVENT_TARGET_CONTRADICTION = "Si des messages sur des évènements intermédiaires ont été configurés, la réception des tâches ne doit pas être utilisée et vice-versa.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_TRIGGER = "Seulement les Evènements de déclenchement intermédiaire suivants sont valides: Message, Signal, Compte à rebour, Conditionnel ou Multiple.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_CONDITION_EXPRESSION = "Le flux sortant des gateways sur évènement ne doivent pas avoir d'expression conditionnée.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_NOT_INSTANTIATING = "La Gateway ne rencontre pas les conditions pour initier le processus. Merci d'utiliser un évènement de Départ ou un attribut d'instantiation pour la gateway.";

/** New Language Properties 05.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_MIXED_FAILURE = "La gateway doit posséder de multiples flux d'entrée et sortie.";
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_CONVERGING_FAILURE = "La gateway doit avoir de multiples flux d'entrée mais ne doit pas avoir de multiples flux de sortie.";
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_DIVERGING_FAILURE = "La gateway ne doit pas avoir de multiples flux d'entrée  mais doit avoir de multiples flux de sortie.";
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAY_WITH_NO_OUTGOING_SEQUENCE_FLOW = "Une gateway doit avoir au minimum un flux de sortie.";
ORYX.I18N.SyntaxChecker.BPMN2_RECEIVE_TASK_WITH_ATTACHED_EVENT = "Les tâches reçues utilisées par les gateway sur évènement ne doivent pas être reliés à des évènement intermédiaires.";
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_SUBPROCESS_BAD_CONNECTION = "Un sous-processus d'évènement ne doit posséder ni de flux d'entrée ni de flux de sortie.";

/** New Language Properties 13.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_CONNECTED = "Au moins un côté du flux d'information doit être connecté.";

/** New Language Properties 24.11.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_MESSAGES = "Une activité de Choreography peut avoir seulement un message initiateur.";
ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_ALLOWED = "Un flux d'information n'est pas autorisé dans ce cas.";

/** New Language Properties 27.11.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_INCOMING_SEQUENCE_FLOWS = "Une gateway sur évènement non instanciée doit avoir au minimum un flux entrant.";
ORYX.I18N.SyntaxChecker.BPMN2_TOO_FEW_INITIATING_PARTICIPANTS = "Une activité de Choreography doit avoir au moins un Participant initiateur (blanc).";
ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_PARTICIPANTS = "Une activité de Choreography ne doit pas avoir plus d'un Participant initiateur (blanc)."

ORYX.I18N.SyntaxChecker.COMMUNICATION_AT_LEAST_TWO_PARTICIPANTS = "La communication doit être reliée à au moins deux participants.";
ORYX.I18N.SyntaxChecker.MESSAGEFLOW_START_MUST_BE_PARTICIPANT = "Le flux d'information source doit être un participant.";
ORYX.I18N.SyntaxChecker.MESSAGEFLOW_END_MUST_BE_PARTICIPANT = "Le flux d'information cible doit être un participant.";
ORYX.I18N.SyntaxChecker.CONV_LINK_CANNOT_CONNECT_CONV_NODES = "Le lien de communication doit relier une noeud de communication ou de sous-conversation avec un participant.";
