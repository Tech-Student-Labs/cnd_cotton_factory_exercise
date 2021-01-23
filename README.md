# The Cotton Factory

The Cotton Factory is a company that manufactures cotton clothing of all kinds. They currently use microservices to run their online shopping experience, but they want to rebuild the Products service.

The Products service is responsible for all the products that they sell. It includes the details of each product including names, descriptions, sizes, prices and many other details related to each unique product.

It works with the other services which aren't being updated in this phase: Orders and Accounts.

## Exercise
> Duration: 2-4 blocks

This exercise is about your role in the CI/CD cycle and understanding the process of continuous integration. **Fork this repository.**

Your task is to help rebuild the Products service. Everyone in the class is working with the Products service which contains the following products:

* Shirts
* Shoes
* Jackets
* Socks
* Hats
* Slacks
* Skirts
* Dresses

You or your group will be assigned a single product and your task is the implement it and integrate your code with the project.

During this exercise your workflow should look like this:

1. Use the TDD cycle: write a test, make it pass and refactor.
2. Submit MR/PR to the project repository for code review.
3. Participate in the code review process.
4. Frequently update your branch!

Part of the challenge is that during code reviews, you'll need to simultaneously continue working on your next feature, making sure you're keeping your project up-to-date as things are merged by everyone else! This is part of the process of continuous integration.

Instructors will frequently update the project and version tags as the features are developed to deploy the service at the end of the exercise. 

Focus on:

* Research: Learn about the product you're working on so you can develop *reasonable* features for it.
* Tests: Write the strongest tests you can and watch for edge cases.
* Iteration: Small PRs/MRs. A few small commits with good messages.
* Code review: Discuss changes and features with instructors during this process on Github.

The ideal PR/MR only updates a couple of files (the test file and the files under test) and only a few lines of code within each. This helps make your code easy to review and decreases the chances of submitting bugs.

This is an opportunity to practice your dev workflow. Your role in the CI/CD process is to develop well-tested code on a regular basis to contribute to frequent application updates. 
