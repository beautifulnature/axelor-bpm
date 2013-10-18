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
ORYX.I18N.PropertyWindow.dateFormat = "d/m/y";

ORYX.I18N.View.East = "Attributs";
ORYX.I18N.View.West = "Eléments du modèle";

ORYX.I18N.Oryx.title	= "AxelorBPM";
ORYX.I18N.Oryx.pleaseWait = "Veuillez patienter, l'Editeur de workflow AxelorBPM est en cours de chargement...";
ORYX.I18N.Edit.cutDesc = "Couper la sélection dans le presse-papiers";
ORYX.I18N.Edit.copyDesc = "Copier la sélection dans le presse-papiers";
ORYX.I18N.Edit.pasteDesc = "Coller le contenu du presse-papiers dans l'espace de travail";
ORYX.I18N.ERDFSupport.noCanvas = "Le document XML ne contient aucun noeud de travail !";
ORYX.I18N.ERDFSupport.noSS = "Aucune liste d'attributs n'a été définie dans l'espace de travail de l'éditeur de processus AxelorBPM !";
ORYX.I18N.ERDFSupport.deprText = "L'export au format eRDF n'est plus recommandé car ce format ne sera plus maintenu dans les versions ultérieurs de l'Editeur de Processus AxelorBPM. Dans la mesure du possible, il est recommandé d'exporter au format JSON. Souhaitez-vous tout de même continuer l'export dans ce format ?";
ORYX.I18N.Save.pleaseWait = "Merci de patienter<br/>Enregistrement en cours...";

ORYX.I18N.Save.saveAs = "Enregistrer sous...";
ORYX.I18N.Save.saveAsDesc = "Enregistrer sous...";
ORYX.I18N.Save.saveAsTitle = "Enregistrer sous...";
ORYX.I18N.Save.savedAs = "Enregistrement effectué";
ORYX.I18N.Save.savedDescription = "Le diagramme du processus est enregistré sous";
ORYX.I18N.Save.notAuthorized = "Vous êtes maintenant connecté. Merci <a href='/p/login' target='_blank'>de vous rendre</a> dans une nouvelle fenêtre pour que vous puissiez sauvegarder le diagramme en cours."
ORYX.I18N.Save.transAborted = "La demande d'enregistrement a pris beaucoup de temps. Vous devriez utiliser une connection internet avec un débit plus élevé. Si vous utilisez un réseau sans fil, merci de vérifier la puissance du signal reçu.";
ORYX.I18N.Save.noRights = "Vous n'avez pas les droits requis pour enregistrer ce modèle. Merci de vérifier dans l'<a href='/p/explorer' target='_blank'>explorateur AxelorBPM</a>, si vous avez toujours les droits en Ecriture dans le répertoire cible.";
ORYX.I18N.Save.comFailed = "La liaison avec le server AxelorBPM a échouée. Merci de vérifier votre connection internet. Si le problème persiste, veuillez contacter le service support AxelorBPM en cliquant sur l'icône enveloppe dans la barre d'outils.";
ORYX.I18N.Save.failed = "Un évènement inattendu est intervenu lors de la sauvegarde de votre diagramme. Merci de réessayer. Si le problème persiste, veuillez contacter le service support AxelorBPM en cliquant sur l'icône enveloppe dans la barre d'outils. ";
ORYX.I18N.Save.exception = "Des exceptions ont été générées lors de la tentative de sauvegarde du diagramme. Merci de réessayer. Si le problème persiste, veuillez contacter le service support AxelorBPM en cliquant sur l'icône enveloppe dans la barre d'outils.";
ORYX.I18N.Save.retrieveData = "Merci de patienter, les données sont en cours de récupération.";

/** New Language Properties: 10.6.09*/
if(!ORYX.I18N.ShapeMenuPlugin) ORYX.I18N.ShapeMenuPlugin = {};
ORYX.I18N.ShapeMenuPlugin.morphMsg = "Modifier la forme";
ORYX.I18N.ShapeMenuPlugin.morphWarningTitleMsg = "Modifier la forme";
ORYX.I18N.ShapeMenuPlugin.morphWarningMsg = "Il existe des formes Enfants qui ne peuvent être contenues dans l'élément transformé.<br/>Etes-vous certains de vouloir procéder à la transformation ?";

if (!Signavio) { var Signavio = {}; }
if (!Signavio.I18N) { Signavio.I18N = {} }
if (!Signavio.I18N.Editor) { Signavio.I18N.Editor = {} }

if (!Signavio.I18N.Editor.Linking) { Signavio.I18N.Editor.Linking = {} }
Signavio.I18N.Editor.Linking.CreateDiagram = "Créer un nouveau diagramme";
Signavio.I18N.Editor.Linking.UseDiagram = "Utiliser un diagramme existant";
Signavio.I18N.Editor.Linking.UseLink = "Utiliser un lien hypertext";
Signavio.I18N.Editor.Linking.Close = "Fermer";
Signavio.I18N.Editor.Linking.Cancel = "Annuler";
Signavio.I18N.Editor.Linking.UseName = "Choisir un nom de diagramme";
Signavio.I18N.Editor.Linking.UseNameHint = "Remplacer le nom actuel de l'élément modélisé ({type}) par le nom du diagramme associé.";
Signavio.I18N.Editor.Linking.CreateTitle = "Créer un lien";
Signavio.I18N.Editor.Linking.AlertSelectModel = "Vous devez sélectionner un modèle.";
Signavio.I18N.Editor.Linking.ButtonLink = "Rattacher un diagramme";
Signavio.I18N.Editor.Linking.LinkNoAccess = "Vous n'avez pas accès à ce diagramme.";
Signavio.I18N.Editor.Linking.LinkUnavailable = "Le diagramme n'est pas disponible.";
Signavio.I18N.Editor.Linking.RemoveLink = "Supprimer le lien";
Signavio.I18N.Editor.Linking.EditLink = "Editer le lien";
Signavio.I18N.Editor.Linking.OpenLink = "Ouvrir";
Signavio.I18N.Editor.Linking.BrokenLink = "Le lien est cassé !";
Signavio.I18N.Editor.Linking.PreviewTitle = "Aperçu";

if(!Signavio.I18N.Glossary_Support) { Signavio.I18N.Glossary_Support = {}; }
Signavio.I18N.Glossary_Support.renameEmpty = "Aucune entrée dans le dictionnaire";
Signavio.I18N.Glossary_Support.renameLoading = "Recherche en cours...";

/** New Language Properties: 08.09.2009*/
if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};
ORYX.I18N.PropertyWindow.oftenUsed = "Propriétés principales";
ORYX.I18N.PropertyWindow.moreProps = "Plus de propriétés";

ORYX.I18N.PropertyWindow.btnOpen = "Ouvrir";
ORYX.I18N.PropertyWindow.btnRemove = "Supprimer";
ORYX.I18N.PropertyWindow.btnEdit = "Editer";
ORYX.I18N.PropertyWindow.btnUp = "Déplacer en haut";
ORYX.I18N.PropertyWindow.btnDown = "Déplacer en bas";
ORYX.I18N.PropertyWindow.createNew = "Créer un nouveau";

if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};
ORYX.I18N.PropertyWindow.oftenUsed = "Attributs principaux";
ORYX.I18N.PropertyWindow.moreProps = "Plus d'attributs";
ORYX.I18N.PropertyWindow.characteristicNr = "Coût &amp; Analyse des ressources";
ORYX.I18N.PropertyWindow.meta = "Attributs personnalisés";

if(!ORYX.I18N.PropertyWindow.Category){ORYX.I18N.PropertyWindow.Category = {}}
ORYX.I18N.PropertyWindow.Category.popular = "Attributs principaux";
ORYX.I18N.PropertyWindow.Category.characteristicnr = "Coût &amp; Analyse des ressources";
ORYX.I18N.PropertyWindow.Category.others = "Plus d'attributs";
ORYX.I18N.PropertyWindow.Category.meta = "Attributs personnalisés";

if(!ORYX.I18N.PropertyWindow.ListView) ORYX.I18N.PropertyWindow.ListView = {};
ORYX.I18N.PropertyWindow.ListView.title = "Editer: ";
ORYX.I18N.PropertyWindow.ListView.dataViewLabel = "Données déjà existantes.";
ORYX.I18N.PropertyWindow.ListView.dataViewEmptyText = "Aucune donnée saisie.";
ORYX.I18N.PropertyWindow.ListView.addEntryLabel = "Ajouter une nouvelle saisie";
ORYX.I18N.PropertyWindow.ListView.buttonAdd = "Ajouter";
ORYX.I18N.PropertyWindow.ListView.save = "Enregistrer";
ORYX.I18N.PropertyWindow.ListView.cancel = "Annuler";

if(!Signavio.I18N.Buttons) Signavio.I18N.Buttons = {};
Signavio.I18N.Buttons.save		= "Enregistrer";
Signavio.I18N.Buttons.cancel 	= "Annuler";
Signavio.I18N.Buttons.remove	= "Supprimer";

if(!Signavio.I18N.btn) {Signavio.I18N.btn = {};}
Signavio.I18N.btn.btnEdit = "Editer";
Signavio.I18N.btn.btnRemove = "Supprimer";
Signavio.I18N.btn.moveUp = "Déplacer en haut";
Signavio.I18N.btn.moveDown = "Déplacer en bas";

if(!Signavio.I18N.field) {Signavio.I18N.field = {};}
Signavio.I18N.field.Url = "URL";
Signavio.I18N.field.UrlLabel = "Libellé";
