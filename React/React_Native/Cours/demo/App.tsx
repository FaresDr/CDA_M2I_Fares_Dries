import { StyleSheet, Text, View, Image } from 'react-native'
import React from 'react'

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.tinylogoContainer}>
        <Image
          style={styles.tinyLogo}
          source={{
            uri: 'https://reactnative.dev/img/tiny_logo.png',
          }}
        />
      </View>
      <View style={styles.textContainer}>
        <Text>Nom :<Text style={styles.textContainer}>Capitaine</Text></Text>
        <Text>Prenom :<Text style={styles.textContainer}>Haddock</Text></Text>
        <Text>Numéro de téléphone :<Text style={styles.textContainer}> 01.23.45.67.89</Text></Text>
        <Text>Adresse :<Text style={styles.textContainer}> 35 rue des pias 59200 Tourcoing</Text></Text>
      </View>
    </View>
  )
}


const styles = StyleSheet.create({
  container: {
    paddingTop: 50,
    flex: 1,
    justifyContent: "center",

    backgroundColor: "#F6E1CF"
  },
  tinyLogo: {
    width: 100,
    height: 100,
    alignItems: "center",
  },
 
  tinylogoContainer: {
    alignItems: "center"
  },
  textContainer: {
    alignItems: "flex-start",
    margin: 50,
    marginTop: 0,
    fontWeight: "900"
  }
});