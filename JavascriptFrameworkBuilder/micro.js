/*!
 * micro.js v1.0.0
 * (c) 2018-2019 Cody Luo
 * Released under the MIT License.
 */

function _(id) {
  if (id == null) return document.body;
  if(Number.isInteger(id)) return document.body.children[id];
  return document.getElementById(id)
}

function $(sel) {
  return document.querySelector(sel);
}

function isPrime(p) {
  for (let i = 2n; i * i <= p; i++) {
    if (p % i === 0n) return false;
  }
  return true;
}

// Takes a BigInt as an argument and returns a BigInt
function nthPrime(nth) {
  let maybePrime = 2n;
  let prime = 0n;
  
  while (nth >= 0n) {
    if (isPrime(maybePrime)) {
      nth -= 1n;
      prime = maybePrime;
    }
    maybePrime += 1n;
  }
  
  return prime;
}

//nthPrime(20n)